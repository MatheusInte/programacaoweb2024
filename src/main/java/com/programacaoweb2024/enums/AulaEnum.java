package com.programacaoweb2024.enums;

public enum AulaEnum {
    CARDIO("Cardio"),
    LUTA("Luta"),
    PREPARACAO_CAMPEONATO("Preparacao para campeonato"),
    COMPLETA("Completa");

    private final String tipoAula;

    AulaEnum(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getTipoAula(){
        return tipoAula;
    }
}