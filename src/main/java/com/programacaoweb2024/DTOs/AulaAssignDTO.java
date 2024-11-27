package com.programacaoweb2024.DTOs;

import java.util.List;

public record AulaAssignDTO(
        Long usuarioId,
        List<Long> aulasId

) {
}
