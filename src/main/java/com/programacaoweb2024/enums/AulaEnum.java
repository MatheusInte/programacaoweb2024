package com.programacaoweb2024.enums;

public enum AulaEnum {
    CARDIO("Cardio"),
    LUTA("Luta"),
    PREPARACAO_CAMPEONATO("PreparaÃ§ao para campeonato"),
    COMPLETA("Completa");

    private final String tipoEvento;

    AulaEnum(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento(){
        return tipoEvento;
    }
}