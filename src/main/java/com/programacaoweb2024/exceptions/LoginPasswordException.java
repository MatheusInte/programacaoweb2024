package com.programacaoweb2024.exceptions;

public class LoginPasswordException extends IllegalArgumentException{
    public LoginPasswordException(){
        super("Passar a senha é obrigatório!");
    }

    public LoginPasswordException(String message){
        super(message);
    }
}
