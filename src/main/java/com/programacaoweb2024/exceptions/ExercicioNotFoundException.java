package com.programacaoweb2024.exceptions;

public class ExercicioNotFoundException extends RuntimeException{
    public ExercicioNotFoundException(){
        super("Exercicio não encontrado para o Id passado!");
    }

    public ExercicioNotFoundException(String message){
        super(message);
    }
}
