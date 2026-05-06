package com.mibson.gerenciador_descontos_api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler{

    @ExceptionHandler(DescontoInvalidoException.class)
    public ResponseEntity<String> descontoInvalido(DescontoInvalidoException descontoInvalidoException) {
        return ResponseEntity.badRequest().body(descontoInvalidoException.getMessage());
    }

    @ExceptionHandler(NomeInvalidoException.class)
    public ResponseEntity<String> nomeInvalido(NomeInvalidoException nomeInvalidoException) {
        return ResponseEntity.badRequest().body(nomeInvalidoException.getMessage());
    }

    @ExceptionHandler(PrecoInvalidoException.class)
    public ResponseEntity<String> precoInvalido(PrecoInvalidoException precoInvalidoException) {
        return ResponseEntity.badRequest().body(precoInvalidoException.getMessage());
    }

    @ExceptionHandler(TaxaFreteInvalidaException.class)
    public ResponseEntity<String> taxaFreteInvalida(TaxaFreteInvalidaException taxaFreteInvalidaException) {
        return ResponseEntity.badRequest().body(taxaFreteInvalidaException.getMessage());
    }

}
