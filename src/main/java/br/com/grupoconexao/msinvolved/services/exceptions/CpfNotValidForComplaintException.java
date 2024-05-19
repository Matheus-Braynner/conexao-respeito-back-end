package br.com.grupoconexao.msinvolved.services.exceptions;

import java.io.Serial;

public class CpfNotValidForComplaintException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -3697415937347215852L;

    public CpfNotValidForComplaintException(String msg) {
        super(msg);
    }
}
