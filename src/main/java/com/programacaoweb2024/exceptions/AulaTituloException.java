package com.programacaoweb2024.exceptions;

public class AulaTituloException extends IllegalArgumentException{
    public AulaTituloException(){
        super("O titulo é obrigatório!");
    }

    public AulaTituloException(String message){
        super(message);
    }
}
