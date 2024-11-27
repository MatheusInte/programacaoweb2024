package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.enums.UsuarioEnum;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        LocalDate dataDeNascimento,
        String endereco,
        String email,
        UsuarioEnum experiencia,
        List<AulaResponseDTO> aulas
) {
    public UsuarioResponseDTO( Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDataDeNascimento(),
                usuario.getEndereco(),
                usuario.getEmail(),
                usuario.getExperiencia(),
                usuario.getAulas().stream()
                        .map(AulaResponseDTO::new)
                        .toList()
        );
    }
}
