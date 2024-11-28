package com.programacaoweb2024.DTOs;

import java.util.List;

public record ExercicioAssignDTO(
        Long aulaId,
        List<Long> exerciciosId
) {
}
