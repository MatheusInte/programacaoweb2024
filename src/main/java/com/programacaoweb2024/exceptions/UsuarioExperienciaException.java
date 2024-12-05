package com.programacaoweb2024.exceptions;

public class UsuarioExperienciaException extends IllegalArgumentException{
    public UsuarioExperienciaException(){
        super("A experiência do usuário é obrigatório!");
    }

    public UsuarioExperienciaException(String message){
        super(message);
    }
}
