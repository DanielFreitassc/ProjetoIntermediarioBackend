package com.danielfreitas.exercicio05.controllers;

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
import com.danielfreitas.exercicio05.models.UsuarioEntity;
import com.danielfreitas.exercicio05.services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioEntity> saveUsuario(@RequestBody UsuarioRecordDTO usuarioRecordDTO) {
        return usuarioService.saveUsuario(usuarioRecordDTO);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id")Long id, @RequestBody UsuarioRecordDTO usuarioRecordDTO) {
        return usuarioService.updateUsuario(id, usuarioRecordDTO);
    }
}
