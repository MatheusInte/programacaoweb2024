package com.programacaoweb2024.exceptions;

public class RegisterNomeException extends IllegalArgumentException{
    public RegisterNomeException(){
        super("Passar o nome é obrigatório!");
    }

    public RegisterNomeException(String message){
        super(message);
    }
}
