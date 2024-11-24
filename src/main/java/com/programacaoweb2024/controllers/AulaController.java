package com.programacaoweb2024.controllers;

import com.programacaoweb2024.DTOs.*;
import com.programacaoweb2024.services.AulaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    AulaService aulaService;

    @GetMapping
    public ResponseEntity <List<AulaResponseDTO>> listarAulas(){
        return ResponseEntity.ok(aulaService.listarAulas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> buscarAulaPorId(@PathVariable Long id){
        AulaResponseDTO aula = aulaService.buscarAulaPorId(id);
        return ResponseEntity.ok(aula);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AulaResponseDTO> cadastrarAula(@RequestBody @Valid AulaRequestDTO aulaRequestDTO){
        try{
            AulaResponseDTO aulaCadastrada = aulaService.cadastrarAula(aulaRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(aulaCadastrada);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> atualizarUsuario(@RequestBody AulaUpdateDTO aulaUpdateDTO){
        AulaResponseDTO aulaAtualizada = aulaService.atualizarAula(aulaUpdateDTO);
        return ResponseEntity.ok(aulaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarAula(@PathVariable Long id){
        try{
            aulaService.deletarAula(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarTodasAulas(){
        try{
            aulaService.deletarTodasAulas();
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
