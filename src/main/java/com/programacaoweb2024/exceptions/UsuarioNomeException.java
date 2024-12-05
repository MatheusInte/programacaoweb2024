package com.programacaoweb2024.exceptions;

public class UsuarioNomeException extends IllegalArgumentException{
    public UsuarioNomeException(){
        super("O nome do usuário é obrigatório!");
    }

    public UsuarioNomeException(String message){
        super(message);
    }
}
