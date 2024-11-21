package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.enums.UsuarioEnum;

import java.time.LocalDate;

public record UsuarioResponseDTO(
        String nome,
        LocalDate dataDeNascimento,
        String endereco,
        String email,
        UsuarioEnum experiencia
) {
    public UsuarioResponseDTO( Usuario usuario){
        this(
                usuario.getNome(),
                usuario.getDataDeNascimento(),
                usuario.getEndereco(),
                usuario.getEmail(),
                usuario.getExperiencia()
        );
    }
}
