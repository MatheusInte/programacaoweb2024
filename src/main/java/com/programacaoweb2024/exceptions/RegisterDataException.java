package com.programacaoweb2024.exceptions;

public class RegisterDataException extends IllegalArgumentException{
    public RegisterDataException(){
        super("Passar a data é obrigatório!");
    }

    public RegisterDataException(String message){
        super(message);
    }
}
