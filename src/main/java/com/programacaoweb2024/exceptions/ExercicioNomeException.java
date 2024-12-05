package com.programacaoweb2024.exceptions;

public class ExercicioNomeException extends IllegalArgumentException{
    public ExercicioNomeException(){
        super("O nome do exercício é obrigatório!");
    }

    public ExercicioNomeException(String message){
        super(message);
    }
}
