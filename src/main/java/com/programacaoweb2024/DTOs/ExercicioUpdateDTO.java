package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.enums.ExercicioEnum;

public record ExercicioUpdateDTO(
        Long id,
        String nomeExercicio,
        String equipamento,
        ExercicioEnum grupamento
) {
}
