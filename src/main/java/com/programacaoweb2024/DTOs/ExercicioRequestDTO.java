package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.enums.ExercicioEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExercicioRequestDTO(
        //@NotBlank(message = "Nome do Exercicio é obrigatório")
        String nomeExercicio,
        //@NotNull(message = "Equipamento é obrigatório")
        String equipamento,
        //@NotNull(message = "Grupamento é obrigatória")
        ExercicioEnum grupamento
) { }
