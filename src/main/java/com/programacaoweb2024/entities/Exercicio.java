package com.programacaoweb2024.entities;

import com.programacaoweb2024.enums.ExercicioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipoDeExercicio;
    private String execucao;
    @Enumerated(EnumType.STRING)
    private ExercicioEnum grupamento;
}
