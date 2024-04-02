package com.danielfreitas.exercicio05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfreitas.exercicio05.models.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>{
    
}
