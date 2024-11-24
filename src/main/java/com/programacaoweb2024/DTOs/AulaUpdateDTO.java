package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.enums.AulaEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public record AulaUpdateDTO(
        Long id,
        String titulo,
        String descricao,
        LocalDate data,
        LocalTime horario,
        AulaEnum tipoDeAula
) {
}
