package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.enums.AulaEnum;


import java.time.LocalDate;
import java.time.LocalTime;

public record AulaResponseDTO(
        String titulo,
        String descricao,
        LocalDate data,
        LocalTime horario,
        AulaEnum tipoDeAula
) {
    public AulaResponseDTO(Aula aula){
        this(
                aula.getTitulo(),
                aula.getDescricao(),
                aula.getData(),
                aula.getHorario(),
                aula.getTipoDeAula()
        );
    }
}
