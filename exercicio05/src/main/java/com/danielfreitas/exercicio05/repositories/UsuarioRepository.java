package com.danielfreitas.exercicio05.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danielfreitas.exercicio05.models.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,UUID>{
    @Query(value = "SELECT * FROM tb_user ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<UsuarioEntity> findLastUser();
}
