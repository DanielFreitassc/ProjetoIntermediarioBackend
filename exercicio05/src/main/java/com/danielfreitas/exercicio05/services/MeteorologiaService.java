package com.danielfreitas.exercicio05.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.danielfreitas.exercicio05.models.UsuarioEntity;
import com.danielfreitas.exercicio05.repositories.UsuarioRepository;

@Service
public class MeteorologiaService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final String TEMPO_URI = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";

    private List<Double> temperatures;

    public MeteorologiaService() {
        this.temperatures = fetchTemperatures(TEMPO_URI);
    }

    private List<Double> fetchTemperatures(String urlString) {
        List<Double> temperatures = new ArrayList<>();
    
        try {
            URI uri = new URI(urlString);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
    
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray hourlyData = jsonResponse.getJSONObject("hourly").getJSONArray("temperature_2m");
                double currentTemperature = jsonResponse.getJSONObject("current").getDouble("temperature_2m");
                temperatures.add(currentTemperature);
    
                for (int i = 0; i < hourlyData.length(); i++) {
                    temperatures.add(hourlyData.getDouble(i));
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    
        return temperatures;
    }

    public String getMessage() {

        Optional<UsuarioEntity> user = usuarioRepository.findById(1L);
        String nome = user.map(UsuarioEntity::getNome).orElse("sem nome cadastre seu nome na url http://localhost:8080/usuario");
        
        if (temperatures.isEmpty()) {
            return "Não foi possível recuperar os dados de temperatura.";
        }
        double temperatura = temperatures.get(0);

        if (temperatura < 5.0) {
            return "Olá, " + nome + "! Temperatura atual: " + temperatura + "°C. Está muito frio lá fora. Vista-se com roupas quentes!";
        } else if (temperatura >= 5.0 && temperatura < 15.0) {
            return "Olá, " + nome + "! Temperatura atual: " + temperatura + "°C. O tempo está fresco. Uma jaqueta leve pode ser útil.";
        } else {
            return "Olá, " + nome + "! Temperatura atual: " + temperatura + "°C. O clima está agradável. Aproveite o dia!";
        }
    }
}