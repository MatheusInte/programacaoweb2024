package com.programacaoweb2024.controllers;

import com.programacaoweb2024.DTOs.RegisterRequestDTO;
import com.programacaoweb2024.DTOs.UsuarioRequestDTO;
import com.programacaoweb2024.DTOs.UsuarioResponseDTO;
import com.programacaoweb2024.DTOs.UsuarioUpdateDTO;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Operation(description = "Lista todos os Usuários")
    @GetMapping
    public ResponseEntity <List<UsuarioResponseDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @Operation(description = "Busca o Usuário pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable Long id){
        UsuarioResponseDTO usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @Operation(description = "Cadastra Usuário")
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
        try{
            UsuarioResponseDTO usuarioCadastrado = usuarioService.cadastrarUsuario(usuarioRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(description = "Atualiza Usuário pelo Id")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@RequestBody UsuarioUpdateDTO usuarioUpdateDTO){
        UsuarioResponseDTO usuarioAtualizado = usuarioService.atualizarUsuario(usuarioUpdateDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @Operation(description = "Cadastra Usuário")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarNovoUsuario(@RequestBody RegisterRequestDTO request) {
        Usuario novoUsuario = usuarioService.registrarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @Operation(description = "Deleta Usuário pelo Id")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        try{
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(description = "Deleta todos os Usuários")
    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarTodosUsuarios(){
        try{
            usuarioService.deletarTodosUsuarios();
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
