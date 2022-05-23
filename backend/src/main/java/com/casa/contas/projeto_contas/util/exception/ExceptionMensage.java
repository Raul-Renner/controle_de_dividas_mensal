package com.casa.contas.projeto_contas.util.exception;

import org.springframework.http.HttpStatus;

public class ExceptionMensage extends Exception {

    private final String message;
    private final HttpStatus status;

    public ExceptionMensage() {
        this.message = "";
        this.status = HttpStatus.BAD_REQUEST;
    }

    public ExceptionMensage(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public ExceptionMensage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
