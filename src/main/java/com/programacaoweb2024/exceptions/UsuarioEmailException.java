package com.programacaoweb2024.exceptions;

public class UsuarioEmailException extends IllegalArgumentException{
    public UsuarioEmailException(){
        super("O email do usuário é obrigatório!");
    }

    public UsuarioEmailException(String message){
        super(message);
    }
}
