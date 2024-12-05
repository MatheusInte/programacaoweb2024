package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.enums.AulaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AulaRequestDTO(
        //@NotBlank(message = "Título é obrigatório")
        String titulo,
        String descricao,
        //@NotNull(message = "Data é obrigatória")
        LocalDate data,
        //@NotNull(message = "Horario é obrigatório")
        LocalTime horario,
        //@NotNull(message = "Tipo de Aula é obrigatório")
        AulaEnum tipoDeAula
) {
}
