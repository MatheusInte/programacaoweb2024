package com.programacaoweb2024.controllers;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    AulaService aulaService;

    @GetMapping
    public ResponseEntity <List<Aula>> listarAulas(){
        List<Aula> aulas = aulaService.listarAulas();
        return ResponseEntity.ok().body(aulas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarAulaPorId(@PathVariable Long id){
        Aula obj = aulaService.buscarAulaPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Aula> cadastrarAula(@RequestBody Aula aula){
        try{
            Aula aulaCadastrada = aulaService.cadastrarAula(aula);
            return ResponseEntity.ok().body(aulaCadastrada);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
