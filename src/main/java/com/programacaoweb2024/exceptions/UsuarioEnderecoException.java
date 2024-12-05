package com.programacaoweb2024.exceptions;

public class UsuarioEnderecoException extends IllegalArgumentException{
    public UsuarioEnderecoException(){
        super("Passar o endereço é obrigatório!");
    }

    public UsuarioEnderecoException(String message){
        super(message);
    }
}
