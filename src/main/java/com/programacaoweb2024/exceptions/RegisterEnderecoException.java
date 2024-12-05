package com.programacaoweb2024.exceptions;

public class RegisterEnderecoException extends IllegalArgumentException{
    public RegisterEnderecoException(){
        super("Passar o endereço é obrigatório!");
    }

    public RegisterEnderecoException(String message){
        super(message);
    }
}
