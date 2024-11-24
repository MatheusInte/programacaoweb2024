package com.programacaoweb2024.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.programacaoweb2024.enums.UsuarioEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UsuarioUpdateDTO(
        String nome,
        LocalDate dataDeNascimento,
        String endereco,
        String email,
        UsuarioEnum experiencia
) {
}
