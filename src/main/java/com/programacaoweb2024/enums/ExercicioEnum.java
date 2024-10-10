package com.programacaoweb2024.enums;

public enum ExercicioEnum {
    INDIVIDUAL("Individual"),
    DUPLA("Dupla"),
    GRUPO("Grupo");

    private final String tipoExercicio;

    ExercicioEnum(String tipoExercicio){
        this.tipoExercicio = tipoExercicio;
    }

    private String getTipoExercicio(){
        return tipoExercicio;
    }
}