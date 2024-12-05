package com.programacaoweb2024.exceptions;

public class AulaHorarioException extends IllegalArgumentException{
    public AulaHorarioException(){
        super("O horário da aula deve ser entre 06:00 e 21:00!");
    }

    public AulaHorarioException(String message){
        super(message);
    }
}
