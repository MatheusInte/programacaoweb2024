package com.programacaoweb2024.services;


import com.programacaoweb2024.DTOs.ExercicioRequestDTO;
import com.programacaoweb2024.DTOs.ExercicioResponseDTO;
import com.programacaoweb2024.DTOs.ExercicioUpdateDTO;

import java.util.List;

public interface ExercicioService {
    public List<ExercicioResponseDTO> listarExercicios();
    public ExercicioResponseDTO buscarExercicioPorId(Long id);
    public ExercicioResponseDTO cadastrarExercicio(ExercicioRequestDTO exercicioRequestDTO);
    public ExercicioResponseDTO atualizarExercicio(ExercicioUpdateDTO exercicioUpdateDTO);
    public void deletarExercicio(Long id);
    public void deletarTodosExercicios();
}
