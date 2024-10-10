package com.programacaoweb2024.entities;

import com.programacaoweb2024.enums.UsuarioEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDeNascimento;
    private String endereco;
    @Enumerated(EnumType.STRING)
    private UsuarioEnum experiencia;
}
