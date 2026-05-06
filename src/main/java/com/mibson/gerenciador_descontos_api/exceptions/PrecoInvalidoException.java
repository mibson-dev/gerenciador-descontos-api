package com.mibson.gerenciador_descontos_api.exceptions;

public class PrecoInvalidoException extends RuntimeException {
    public PrecoInvalidoException(String message) {
        super(message);
    }
}
