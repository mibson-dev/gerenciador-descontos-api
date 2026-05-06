package com.mibson.gerenciador_descontos_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<String> produtoNaoEncontrado(ProdutoNaoEncontradoException produtoNaoEncontradoException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(produtoNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validacaoNaoConfirmada(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.badRequest().body(methodArgumentNotValidException.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

}
