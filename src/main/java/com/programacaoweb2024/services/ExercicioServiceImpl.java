package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.AulaDTO;
import com.programacaoweb2024.DTOs.ExercicioDTO;
import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExercicioServiceImpl implements ExercicioService{

    @Autowired
    ExercicioRepository exercicioRepository;

    @Override
    public List<ExercicioDTO> listarExercicios() {
        return exercicioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Exercicio buscarExercicioPorId(Long id) {
        Optional<Exercicio> obj = exercicioRepository.findById(id);
        return obj.orElse(null);
    }

    @Override
    public ExercicioDTO cadastrarExercicio(ExercicioDTO exercicioDTO) {
        Exercicio exercicio = converterParaEntidade(exercicioDTO);
        exercicio = exercicioRepository.save(exercicio);

        return converterParaDTO(exercicio);
    }

    @Override
    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }

    private ExercicioDTO converterParaDTO(Exercicio exercicio){
        return new ExercicioDTO(exercicio.getTipoDeExercicio(), exercicio.getExecucao(),
                exercicio.getGrupamento(), exercicio.getAula());
    }

    private Exercicio converterParaEntidade(ExercicioDTO exercicioDTO){
        Exercicio exercicio = new Exercicio();

        exercicio.setTipoDeExercicio(exercicioDTO.getTipoDeExercicio());
        exercicio.setExecucao(exercicioDTO.getExecucao());
        exercicio.setGrupamento(exercicioDTO.getGrupamento());
        exercicio.setAula(exercicioDTO.getAula());

        return exercicio;
    }
}
