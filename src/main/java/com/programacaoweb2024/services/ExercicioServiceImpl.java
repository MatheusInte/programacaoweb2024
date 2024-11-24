package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.ExercicioRequestDTO;
import com.programacaoweb2024.DTOs.ExercicioResponseDTO;
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
    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }

    @Override
    public void deletarTodosExercicios(){
        exercicioRepository.deleteAll();
    }

}
