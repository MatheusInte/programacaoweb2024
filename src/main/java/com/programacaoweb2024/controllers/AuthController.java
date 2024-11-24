package com.programacaoweb2024.controllers;

import com.programacaoweb2024.DTOs.LoginRequestDTO;
import com.programacaoweb2024.DTOs.LoginResponseDTO;
import com.programacaoweb2024.DTOs.RegisterRequestDTO;
import com.programacaoweb2024.DTOs.RegisterResponseDTO;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.repositories.UsuarioRepository;
import com.programacaoweb2024.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final TokenService tokenService;
    @Autowired
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){

        var usernamePassword = new UsernamePasswordAuthenticationToken(body.email(), body.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));


        //Usuario usuario = this.usuarioRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        //if(passwordEncoder.matches(body.password(), usuario.getPassword())){
        //    String token = this.tokenService.generateToken(usuario);
        //    return ResponseEntity.ok(new LoginResponseDTO(usuario.getNome(), token));
        //}
        //return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(body.email());

        if(usuario.isEmpty()){
            Usuario novoUsuario = new Usuario();
            novoUsuario.setPassword(passwordEncoder.encode(body.password()));
            novoUsuario.setEmail(body.email());
            novoUsuario.setRole(body.role());
            this.usuarioRepository.save(novoUsuario);

            String token = this.tokenService.generateToken(novoUsuario);
            return ResponseEntity.ok(new RegisterResponseDTO(novoUsuario.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
