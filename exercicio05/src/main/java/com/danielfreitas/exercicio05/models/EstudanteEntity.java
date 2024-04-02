package com.danielfreitas.exercicio05.models;

import lombok.Data;

@Data
public class EstudanteEntity {
    private String nome = "Daniel Freitas";
    private String projeto = "Serviço de meteorologia";

    public String estudante() {
        return  "Estudante: " + nome + " Projeto: " + projeto;
    }
    
}
