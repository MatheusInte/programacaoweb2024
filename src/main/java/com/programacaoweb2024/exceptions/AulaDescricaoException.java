package com.programacaoweb2024.exceptions;

public class AulaDescricaoException extends IllegalArgumentException{
    public AulaDescricaoException(){
        super("A descrição da aula é obrigatória.!");
    }

    public AulaDescricaoException(String message){
        super(message);
    }
}
