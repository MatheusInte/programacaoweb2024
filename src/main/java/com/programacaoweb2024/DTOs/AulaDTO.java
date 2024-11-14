package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.enums.AulaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AulaDTO {
    private String titulo;
    private String descricao;
    private LocalDate data;
    private AulaEnum tipoDeAula;
    private List<Exercicio> exercicios;
    private Usuario usuario;
}
