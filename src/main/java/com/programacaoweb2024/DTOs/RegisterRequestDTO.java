package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.enums.UserRole;

public record RegisterRequestDTO(String email, String password, UserRole role) {
}
