package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioServiceImpl implements ExercicioService{

    @Autowired
    ExercicioRepository exercicioRepository;

    @Override
    public List<Exercicio> listarExercicios() {
        return exercicioRepository.findAll();
    }

    @Override
    public Exercicio buscarExercicioPorId(Long id) {
        Optional<Exercicio> obj = exercicioRepository.findById(id);
        return obj.orElse(null);
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
