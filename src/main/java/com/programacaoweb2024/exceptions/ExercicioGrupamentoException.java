package com.programacaoweb2024.exceptions;

public class ExercicioGrupamentoException extends IllegalArgumentException{
    public ExercicioGrupamentoException(){
        super("O grupamento é obrigatório!");
    }

    public ExercicioGrupamentoException(String message){
        super(message);
    }
}
