package com.jorge.proyectoDefinitivo.exception;

public class TareaNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TareaNotfoundException(String message) {
        super(message);
    }
}
