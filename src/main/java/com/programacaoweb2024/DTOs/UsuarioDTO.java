package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.enums.UsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nome;
    private LocalDate dataDeNascimento;
    private String endereco;
    private UsuarioEnum experiencia;
    private List<Aula> aulas;
}
