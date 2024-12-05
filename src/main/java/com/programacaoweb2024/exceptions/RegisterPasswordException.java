package com.programacaoweb2024.exceptions;

public class RegisterPasswordException extends IllegalArgumentException{
    public RegisterPasswordException(){
        super("Passar a senha é obrigatório!");
    }

    public RegisterPasswordException(String message){
        super(message);
    }
}
