package com.programacaoweb2024.exceptions;

public class LoginEmailException extends IllegalArgumentException{
    public LoginEmailException(){
        super("Passar o email é obrigatório!");
    }

    public LoginEmailException(String message){
        super(message);
    }
}
