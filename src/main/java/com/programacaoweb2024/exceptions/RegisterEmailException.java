package com.programacaoweb2024.exceptions;

public class RegisterEmailException extends IllegalArgumentException{
    public RegisterEmailException(){
        super("Passar o email é obrigatório!");
    }

    public RegisterEmailException(String message){
        super(message);
    }
}
