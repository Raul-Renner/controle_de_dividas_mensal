package com.casa.contas.projeto_contas.util.exception;

import javax.security.sasl.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
    public InvalidJwtAuthenticationException(String msg){
        super(msg);
    }

}
