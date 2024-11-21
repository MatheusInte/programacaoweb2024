package com.programacaoweb2024.controllers;

import com.programacaoweb2024.DTOs.ExercicioRequestDTO;
import com.programacaoweb2024.DTOs.ExercicioResponseDTO;
import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.services.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    @Autowired
    ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<ExercicioResponseDTO>> listarExercicios(){
        return ResponseEntity.ok(exercicioService.listarExercicios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> buscarExercicioPorId(@PathVariable Long id){
        ExercicioResponseDTO exercicio = exercicioService.buscarExercicioPorId(id);
        return ResponseEntity.ok(exercicio);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ExercicioResponseDTO> cadastrarExercicio(@RequestBody @Valid ExercicioRequestDTO exercicioRequestDTO){
        try{
            ExercicioResponseDTO exercicioCadastrado = exercicioService.cadastrarExercicio(exercicioRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(exercicioCadastrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarExercicio(@PathVariable Long id){
        try{
            exercicioService.deletarExercicio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
