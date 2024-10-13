package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExercicioServiceImpl implements ExercicioService{

    @Autowired
    ExercicioRepository exercicioRepository;

    @Override
    public List<Exercicio> listarExercicios() {
        return exercicioRepository.findAll();
    }

    @Override
    public Exercicio buscarExercicioPorId(Long id) {
        return exercicioRepository.findById(id).orElse(null);
    }

    @Override
    public Exercicio cadastrarExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    @Override
    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
