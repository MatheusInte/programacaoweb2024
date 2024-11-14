package com.programacaoweb2024.entities;

import com.programacaoweb2024.enums.UsuarioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;
    private String endereco;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UsuarioEnum experiencia;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Aula> aulas;
}
