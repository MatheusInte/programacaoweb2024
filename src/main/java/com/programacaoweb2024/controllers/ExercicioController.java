package com.programacaoweb2024.controllers;

import com.programacaoweb2024.DTOs.*;
import com.programacaoweb2024.services.ExercicioService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(description = "Lista todos os Exercícios")
    @GetMapping
    public ResponseEntity<List<ExercicioResponseDTO>> listarExercicios(){
        return ResponseEntity.ok(exercicioService.listarExercicios());
    }

    @Operation(description = "Busca o Exercício pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> buscarExercicioPorId(@PathVariable Long id){
        ExercicioResponseDTO exercicio = exercicioService.buscarExercicioPorId(id);
        return ResponseEntity.ok(exercicio);
    }

    @Operation(description = "Cadastra Exercício")
    @PostMapping("/cadastrar")
    public ResponseEntity<ExercicioResponseDTO> cadastrarExercicio(@RequestBody @Valid ExercicioRequestDTO exercicioRequestDTO){
        try{
            ExercicioResponseDTO exercicioCadastrado = exercicioService.cadastrarExercicio(exercicioRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(exercicioCadastrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(description = "Deleta Exercicio pelo Id")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarExercicio(@PathVariable Long id){
        try{
            exercicioService.deletarExercicio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(description = "Atualiza Exercício pelo Id")
    @PutMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> atualizarExercicio(@RequestBody ExercicioUpdateDTO exercicioUpdateDTO){
        ExercicioResponseDTO exercicioAtualizado = exercicioService.atualizarExercicio(exercicioUpdateDTO);
        return ResponseEntity.ok(exercicioAtualizado);
    }


    @Operation(description = "Atribue Exercício a Aula")
    @PostMapping("/atribuir")
    public ResponseEntity<AulaResponseDTO> atribuirExercicios(@RequestBody ExercicioAssignDTO exercicioAssignDTO){
        AulaResponseDTO aulaAtribuida = exercicioService.atribuirExercicios(exercicioAssignDTO);
        return ResponseEntity.ok(aulaAtribuida);
    }

    @Operation(description = "Deleta todos os Exercícios")
    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarTodosExercicios(){
        try{
            exercicioService.deletarTodosExercicios();
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
