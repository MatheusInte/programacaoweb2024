package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.enums.AulaEnum;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record AulaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        LocalDate data,
        LocalTime horario,
        AulaEnum tipoDeAula,
        List<ExercicioResponseDTO> exercicios
) {
    public AulaResponseDTO(Aula aula){
        this(
                aula.getId(),
                aula.getTitulo(),
                aula.getDescricao(),
                aula.getData(),
                aula.getHorario(),
                aula.getTipoDeAula(),
                aula.getExercicios().stream()
                        .map(ExercicioResponseDTO::new)
                        .toList()
        );
    }
}
