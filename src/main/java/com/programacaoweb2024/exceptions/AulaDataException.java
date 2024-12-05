package com.programacaoweb2024.exceptions;

public class AulaDataException extends IllegalArgumentException{
    public AulaDataException(){
        super("A data da aula é obrigatória.!");
    }

    public AulaDataException(String message){
        super(message);
    }
}
