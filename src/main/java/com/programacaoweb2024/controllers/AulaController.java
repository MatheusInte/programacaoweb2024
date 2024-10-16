package com.programacaoweb2024.controllers;


import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.services.AulaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    AulaServiceImpl aulaService;

    @GetMapping("/")
    public ResponseEntity<List<Aula>> listarAulas(){
        List<Aula> aulas = aulaService.listarAulas();
        return ResponseEntity.ok(aulas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> listarPorId(@PathVariable Long id){
        Aula aula = aulaService.buscarAulaPorId(id);
        if(aula != null){
            return ResponseEntity.status(200).body(aula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Aula> cadastrarAula(@RequestBody Aula aula){
        Aula novaAula = aulaService.cadastrarAula(aula);
        return ResponseEntity.ok().body(novaAula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> atualizarAula(@PathVariable Long id, @RequestBody Aula aula){
        aula.setId(id);
        Aula novaAula = aulaService.atualizarAula(id, aula);
        return ResponseEntity.ok().body(novaAula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAula(@PathVariable Long id){
        aulaService.deletarAula(id);
        return ResponseEntity.noContent().build();
    }
}
