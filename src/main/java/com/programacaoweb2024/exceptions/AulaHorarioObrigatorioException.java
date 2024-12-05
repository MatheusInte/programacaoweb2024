package com.programacaoweb2024.exceptions;

public class AulaHorarioObrigatorioException extends NullPointerException{
    public AulaHorarioObrigatorioException(){
        super("O horário da aula é obrigatório");
    }

    public AulaHorarioObrigatorioException(String message){
        super(message);
    }
}
