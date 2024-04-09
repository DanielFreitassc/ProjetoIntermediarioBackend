package com.danielfreitas.exercicio05.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitas.exercicio05.dtos.UsuarioRecordDTO;
import com.danielfreitas.exercicio05.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioRecordDTO usuarioRecordDTO) {
        return usuarioService.saveUsuario(usuarioRecordDTO);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id")UUID id, @RequestBody @Valid UsuarioRecordDTO usuarioRecordDTO) {
        return usuarioService.updateUsuario(id, usuarioRecordDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id")UUID id) {
        return usuarioService.deleteUsuario(id);
    }
}
