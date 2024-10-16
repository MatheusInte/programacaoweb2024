package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.repositories.AulaRepository;
import com.programacaoweb2024.repositories.ExercicioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioServiceImpl implements ExercicioService{

    @Autowired
    AulaRepository aulaRepository;

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
    @Transactional
    public Exercicio cadastrarExercicio(Exercicio exercicio) {
        Optional<Aula> aula = aulaRepository.findById(exercicio.getAula().getId());
        if (!aula.isPresent()) {
            throw new EntityNotFoundException("Aula com ID " + exercicio.getAula().getId() + " não encontrada.");
        }

        return exercicioRepository.save(exercicio);
    }

    @Override
    @Transactional
    public Exercicio atualizarExercicio(Long id, Exercicio exercicio){
        Exercicio exercicioAtualizado = exercicioRepository.findById(exercicio.getId())
                .orElseThrow(() -> new EntityNotFoundException("Exercicio não encontrado"));

        exercicioAtualizado.setId(exercicio.getId());
        exercicioAtualizado.setExecucao(exercicio.getExecucao());
        exercicioAtualizado.setTipoDeExercicio(exercicio.getTipoDeExercicio());
        exercicioAtualizado.setAula(exercicio.getAula());
        exercicioAtualizado.setGrupamento(exercicio.getGrupamento());

        return exercicioRepository.save(exercicioAtualizado);
    }

    @Override
    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
