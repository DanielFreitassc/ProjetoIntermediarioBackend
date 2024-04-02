package com.danielfreitas.exercicio05.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitas.exercicio05.services.MeteorologiaService;

@RestController
@RequestMapping("tempo")
public class MeteorologiaController {

    @Autowired
    private MeteorologiaService meteorologiaService;

    @GetMapping
    public String getTempo() {
        return meteorologiaService.getMessage();
    }

}
