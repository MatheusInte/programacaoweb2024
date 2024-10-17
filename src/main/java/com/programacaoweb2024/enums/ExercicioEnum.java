package com.programacaoweb2024.enums;

public enum ExercicioEnum {
    INDIVIDUAL("Individual"),
    DUPLA("Dupla"),
    GRUPO("Grupo");

    private final String grupamento;

    ExercicioEnum(String grupamento){
        this.grupamento = grupamento;
    }

    private String getGrupamento(){
        return grupamento;
    }
}