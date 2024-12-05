package com.programacaoweb2024.exceptions;

public class AulaTipoDeAulaException extends IllegalArgumentException{
    public AulaTipoDeAulaException(){
        super("O tipo da aula é obrigatório.!");
    }

    public AulaTipoDeAulaException(String message){
        super(message);
    }
}
