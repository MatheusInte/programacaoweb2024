package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.ExercicioDTO;
import com.programacaoweb2024.entities.Exercicio;

import java.util.List;

public interface ExercicioService {
    public List<ExercicioDTO> listarExercicios();
    public Exercicio buscarExercicioPorId(Long id);
    public ExercicioDTO cadastrarExercicio(ExercicioDTO exercicioDTO);
    public void deletarExercicio(Long id);
}
