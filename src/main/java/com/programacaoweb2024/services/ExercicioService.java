package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Exercicio;

import java.util.List;

public interface ExercicioService {
    public List<Exercicio> listarExercicios();
    public Exercicio buscarExercicioPorId(Long id);
    public Exercicio cadastrarExercicio(Exercicio exercicio);
    public void deletarExercicio(Long id);
}
