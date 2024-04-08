package com.danielfreitas.exercicio05.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitas.exercicio05.models.EstudanteEntity;

@RestController
@RequestMapping("ajuda")
public class EstudanteController {

    @GetMapping
    public ResponseEntity<Object> estudanteInfo() {
        EstudanteEntity estudanteEntity = new EstudanteEntity();
        return ResponseEntity.status(HttpStatus.OK).body(estudanteEntity);
    }
    
}
