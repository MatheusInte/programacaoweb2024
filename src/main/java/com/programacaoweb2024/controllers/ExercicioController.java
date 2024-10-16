package com.programacaoweb2024.controllers;

import com.programacaoweb2024.entities.Exercicio;
import com.programacaoweb2024.services.ExercicioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    @Autowired
    ExercicioServiceImpl exercicioService;

    @GetMapping("/")
    public ResponseEntity<List<Exercicio>> listarExercicios(){
        List<Exercicio> exercicio = exercicioService.listarExercicios();
        return ResponseEntity.ok(exercicio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> listarPorId(@PathVariable Long id){
        Exercicio exercicio = exercicioService.buscarExercicioPorId(id);
        if(exercicio != null){
            return ResponseEntity.status(200).body(exercicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Exercicio> cadastrarExercicio(@RequestBody Exercicio exercicio){
        Exercicio novoExercicio = exercicioService.cadastrarExercicio(exercicio);
        return ResponseEntity.ok().body(novoExercicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizarExercicio(@PathVariable Long id, @RequestBody Exercicio exercicio){
        exercicio.setId(id);
        Exercicio novoExercicio = exercicioService.atualizarExercicio(id, exercicio);
        return ResponseEntity.ok().body(novoExercicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarExercicio(@PathVariable Long id){
        exercicioService.deletarExercicio(id);
        return ResponseEntity.noContent().build();
    }
}
