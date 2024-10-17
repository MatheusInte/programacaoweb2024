package com.programacaoweb2024.controllers;

import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    @Autowired
    ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<Exercicio>> listarExercicios(){
        List<Exercicio> exercicios = exercicioService.listarExercicios();
        return ResponseEntity.ok().body(exercicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarExercicioPorId(@PathVariable Long id){
        Exercicio obj = exercicioService.buscarExercicioPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Exercicio> cadastrarExercicio(@RequestBody Exercicio exercicio){
        try{
            Exercicio exercicioCadastrado = exercicioService.cadastrarExercicio(exercicio);
            return ResponseEntity.ok().body(exercicioCadastrado);
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
