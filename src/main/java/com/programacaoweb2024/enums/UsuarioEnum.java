package com.programacaoweb2024.enums;

public enum UsuarioEnum {
    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    ATLETA("Atleta");

    private final String experiencia;

    UsuarioEnum(String experiencia){
        this.experiencia = experiencia;
    }

    private String getExperiencia(){
        return experiencia;
    }
}
