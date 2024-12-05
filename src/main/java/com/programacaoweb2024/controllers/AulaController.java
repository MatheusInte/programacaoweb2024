package com.programacaoweb2024.controllers;

import com.programacaoweb2024.DTOs.*;
import com.programacaoweb2024.services.AulaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(description = "Lista todas as Aulas")
    @GetMapping
    public ResponseEntity <List<AulaResponseDTO>> listarAulas(){
        return ResponseEntity.ok(aulaService.listarAulas());
    }

    @Operation(description = "Busca a Aula pelo Id")
    @ApiResponse(responseCode = "200", description = "Retorna a Aula pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> buscarAulaPorId(@PathVariable Long id){
        AulaResponseDTO aula = aulaService.buscarAulaPorId(id);
        return ResponseEntity.ok(aula);
    }

    @Operation(description = "Cadastra Aula")
    @PostMapping("/cadastrar")
    public ResponseEntity<AulaResponseDTO> cadastrarAula(@RequestBody @Valid AulaRequestDTO aulaRequestDTO){
            AulaResponseDTO aulaCadastrada = aulaService.cadastrarAula(aulaRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(aulaCadastrada);
    }

    @Operation(description = "Atualiza Aula pelo Id")
    @PutMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> atualizarAula(@RequestBody AulaUpdateDTO aulaUpdateDTO){
        AulaResponseDTO aulaAtualizada = aulaService.atualizarAula(aulaUpdateDTO);
        return ResponseEntity.ok(aulaAtualizada);
    }

    @Operation(description = "Atribue Aula a Usuário")
    @PostMapping("/atribuir")
    public ResponseEntity<UsuarioResponseDTO> atribuirAulas(@RequestBody AulaAssignDTO aulaAssignDTO){
        UsuarioResponseDTO usuarioAtribuido = aulaService.atribuirAulas(aulaAssignDTO);
        return ResponseEntity.ok(usuarioAtribuido);
    }

    @Operation(description = "Deleta Aula pelo Id")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarAula(@PathVariable Long id){
        try{
            aulaService.deletarAula(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(description = "Deleta todas as Aulas")
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
