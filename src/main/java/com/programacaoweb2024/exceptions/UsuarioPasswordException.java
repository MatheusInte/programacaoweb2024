package com.programacaoweb2024.exceptions;

public class UsuarioPasswordException extends IllegalArgumentException{
    public UsuarioPasswordException(){
        super("A senha do usuário é obrigatória!");
    }

    public UsuarioPasswordException(String message){
        super(message);
    }
}
