package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.*;
import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.repositories.AulaRepository;
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

    @Autowired
    AulaRepository aulaRepository;

    @Override
    public List<ExercicioResponseDTO> listarExercicios() {
        List<Exercicio> exercicios = exercicioRepository.findAll();
        return exercicios.stream()
                .map(ExercicioResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ExercicioResponseDTO buscarExercicioPorId(Long id) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não Encontrado"));
        return new ExercicioResponseDTO(exercicio);
    }

    @Override
    public ExercicioResponseDTO cadastrarExercicio(ExercicioRequestDTO exercicioRequestDTO) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNomeExercicio(exercicioRequestDTO.nomeExercicio());
        exercicio.setEquipamento(exercicioRequestDTO.equipamento());
        exercicio.setGrupamento(exercicioRequestDTO.grupamento());

        Exercicio exercicioSalvo = exercicioRepository.save(exercicio);

        return new ExercicioResponseDTO(exercicioSalvo);
    }

    @Override
    public ExercicioResponseDTO atualizarExercicio(ExercicioUpdateDTO exercicioUpdateDTO){
        Exercicio exercicio = exercicioRepository.findById(exercicioUpdateDTO.id())
                .orElseThrow(()-> new IllegalArgumentException("Exercicio de ID: " + exercicioUpdateDTO.id() + "não encontrado"));

        exercicio.setNomeExercicio(exercicioUpdateDTO.nomeExercicio());
        exercicio.setEquipamento(exercicioUpdateDTO.equipamento());
        exercicio.setGrupamento(exercicioUpdateDTO.grupamento());

        Exercicio exercicioAtualizado = exercicioRepository.save(exercicio);

        return new ExercicioResponseDTO(exercicioAtualizado);
    }

    @Override
    public AulaResponseDTO atribuirExercicios(ExercicioAssignDTO exercicioAssignDTO){
        Aula aula = aulaRepository.findById(exercicioAssignDTO.aulaId())
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));
        List<Exercicio> exercicios = exercicioRepository.findAllById(exercicioAssignDTO.exerciciosId());

        if (exercicios.isEmpty()){
            throw new RuntimeException("Exercicio não encontrado para o Id passado");
        }
        for (Exercicio exercicio : exercicios){
            exercicio.setAula(aula);
        }

        exercicioRepository.saveAll(exercicios);

        return new AulaResponseDTO(aula);
    }

    @Override
    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }

    @Override
    public void deletarTodosExercicios(){
        exercicioRepository.deleteAll();
    }

}
