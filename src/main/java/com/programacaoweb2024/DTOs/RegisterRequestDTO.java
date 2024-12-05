package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.enums.UserRole;
import com.programacaoweb2024.enums.UsuarioEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterRequestDTO(
        //@NotBlank(message = "Nome é obrigatório")
        String nome,
        //@NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataDeNascimento,
        //@NotBlank(message = "Endereço é obrigatório")
        String endereco,
        //@NotBlank(message = "Email é obrigatório")
        String email,
        //@NotBlank(message = "Senha é obrigatório")
        String password,
        //@NotNull(message = "Experiência é obrigatória")
        UsuarioEnum experiencia,
        //@NotNull(message = "Role é obrigatória")
        UserRole role
) {}
