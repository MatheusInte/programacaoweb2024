package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.enums.UserRole;
import com.programacaoweb2024.enums.UsuarioEnum;

import java.time.LocalDate;

public record RegisterResponseDTO(
        String name,
        LocalDate dataDeNascimento,
        UsuarioEnum experiencia,
        UserRole role,
        String token
) {}
