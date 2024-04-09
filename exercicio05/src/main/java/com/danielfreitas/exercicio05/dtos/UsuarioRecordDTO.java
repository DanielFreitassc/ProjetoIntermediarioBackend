package com.danielfreitas.exercicio05.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDTO(@NotBlank(message = "O campo nome não pode estar em branco") String nome) {

}
