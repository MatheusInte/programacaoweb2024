package com.programacaoweb2024.exceptions;

public class ExercicioExerciciosException extends IllegalArgumentException{
    public ExercicioExerciciosException(){
        super("Descrever os exercícios é obrigatório!");
    }

    public ExercicioExerciciosException(String message){
        super(message);
    }
}
