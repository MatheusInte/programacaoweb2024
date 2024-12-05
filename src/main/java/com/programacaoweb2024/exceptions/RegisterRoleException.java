package com.programacaoweb2024.exceptions;

public class RegisterRoleException extends IllegalArgumentException{
    public RegisterRoleException(){
        super("Passar a role do usuário é obrigatório!");
    }

    public RegisterRoleException(String message){
        super(message);
    }
}
