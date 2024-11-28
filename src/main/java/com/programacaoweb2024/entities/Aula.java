package com.programacaoweb2024.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.programacaoweb2024.enums.AulaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate data;
    private LocalTime horario;
    @Enumerated(EnumType.STRING)
    private AulaEnum tipoDeAula;
    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
    private List<Exercicio> exercicios;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}