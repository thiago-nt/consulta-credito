package com.consulta.credito.exception;

public class CreditoNotFoundException extends RuntimeException {

    public CreditoNotFoundException(String numeroCredito) {
        super("Crédito com número " + numeroCredito + " não encontrado.");
    }

    public CreditoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditoNotFoundException(Throwable cause) {
        super(cause);
    }
}