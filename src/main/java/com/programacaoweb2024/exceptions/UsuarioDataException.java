package com.programacaoweb2024.exceptions;

public class UsuarioDataException extends IllegalArgumentException{
    public UsuarioDataException(){
        super("Passar a data é obrigatório!");
    }

    public UsuarioDataException(String message){
        super(message);
    }
}
