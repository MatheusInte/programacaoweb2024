package com.programacaoweb2024.DTOs;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.enums.ExercicioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ExercicioDTO {
    private String tipoDeExercicio;
    private String execucao;
    private ExercicioEnum grupamento;
    private Aula aula;
}
