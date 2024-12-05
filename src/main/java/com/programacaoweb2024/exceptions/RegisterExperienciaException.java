package com.programacaoweb2024.exceptions;

public class RegisterExperienciaException extends IllegalArgumentException{
    public RegisterExperienciaException(){
        super("Passar a experiência é obrigatório!");
    }

    public RegisterExperienciaException(String message){
        super(message);
    }
}
