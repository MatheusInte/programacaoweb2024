package com.programacaoweb2024.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.DateTimeException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AulaTituloException.class)
    public ResponseEntity<String> handlerAulaTituloException(AulaTituloException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AulaHorarioException.class)
    public ResponseEntity<String> handlerAulaHorarioException(AulaHorarioException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler({AulaHorarioObrigatorioException.class, NullPointerException.class})
    public ResponseEntity<String> handlerAulaHorarioObrigatorioException(AulaHorarioObrigatorioException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AulaDataException.class)
    public ResponseEntity<String> handlerAulaDataException(AulaDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AulaDescricaoException.class)
    public ResponseEntity<String> handlerAulaDescricaoException(AulaDescricaoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AulaTipoDeAulaException.class)
    public ResponseEntity<String> handlerAulaTipoDeAulaException(AulaTipoDeAulaException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ExercicioNomeException.class)
    public ResponseEntity<String> handlerExercicioNomeException(ExercicioNomeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ExercicioExerciciosException.class)
    public ResponseEntity<String> handlerExercicioExerciciosException(ExercicioExerciciosException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ExercicioGrupamentoException.class)
    public ResponseEntity<String> handlerExercicioGrupamentoException(ExercicioGrupamentoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ExercicioNotFoundException.class)
    public ResponseEntity<String> handlerExercicioNotFoundException(ExercicioNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterNomeException.class)
    public ResponseEntity<String> handlerRegisterNomeException(RegisterNomeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterDataException.class)
    public ResponseEntity<String> handlerRegisterDataException(RegisterDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterEnderecoException.class)
    public ResponseEntity<String> handlerRegisterEnderecoException(RegisterEnderecoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterEmailException.class)
    public ResponseEntity<String> handlerRegisterEmailException(RegisterEmailException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterPasswordException.class)
    public ResponseEntity<String> handlerRegisterPasswordException(RegisterPasswordException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterExperienciaException.class)
    public ResponseEntity<String> handlerRegisterExperienciaException(RegisterExperienciaException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RegisterRoleException.class)
    public ResponseEntity<String> handlerRegisterRoleException(RegisterRoleException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(LoginEmailException.class)
    public ResponseEntity<String> handlerLoginEmailException(LoginEmailException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(LoginPasswordException.class)
    public ResponseEntity<String> handlerLoginPasswordException(LoginPasswordException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioNomeException.class)
    public ResponseEntity<String> handlerUsuarioNomeException(UsuarioNomeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioDataException.class)
    public ResponseEntity<String> handlerUsuarioDataException(UsuarioDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioEnderecoException.class)
    public ResponseEntity<String> handlerUsuarioEnderecoException(UsuarioEnderecoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioEmailException.class)
    public ResponseEntity<String> handlerUsuarioEmailException(UsuarioEmailException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioPasswordException.class)
    public ResponseEntity<String> handlerUsuarioPasswordException(UsuarioPasswordException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioExperienciaException.class)
    public ResponseEntity<String> handlerUsuarioExperienciaException(UsuarioExperienciaException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<String> handlerDataTimeException(DateTimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
