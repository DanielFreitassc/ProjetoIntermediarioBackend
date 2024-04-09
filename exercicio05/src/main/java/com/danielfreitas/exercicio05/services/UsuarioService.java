package com.danielfreitas.exercicio05.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.danielfreitas.exercicio05.dtos.UsuarioRecordDTO;
import com.danielfreitas.exercicio05.models.UsuarioEntity;
import com.danielfreitas.exercicio05.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Object> saveUsuario(UsuarioRecordDTO usuarioRecordDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioRecordDTO, usuarioEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioEntity));
    } 

    public ResponseEntity<Object> updateUsuario(UUID id, UsuarioRecordDTO usuarioRecordDTO) {
        Optional<UsuarioEntity> user = usuarioRepository.findById(id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuario com este id");
        }
        UsuarioEntity usuarioEntity = user.get();
        BeanUtils.copyProperties(usuarioRecordDTO, usuarioEntity);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioEntity));
    }

    public ResponseEntity<Object> deleteUsuario(UUID id) {
        Optional<UsuarioEntity> user = usuarioRepository.findById(id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuario com este id");
        }
        usuarioRepository.delete(user.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
