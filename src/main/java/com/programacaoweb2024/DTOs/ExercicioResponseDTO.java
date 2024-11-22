package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.enums.ExercicioEnum;


public record ExercicioResponseDTO(
        Long id,
        String nomeExercicio,
        String equipamento,
        ExercicioEnum grupamento
) {
    public ExercicioResponseDTO(Exercicio exercicio){
        this(
                exercicio.getId(),
                exercicio.getNomeExercicio(),
                exercicio.getEquipamento(),
                exercicio.getGrupamento()
        );
    }
}
