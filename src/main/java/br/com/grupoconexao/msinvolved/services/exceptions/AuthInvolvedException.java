package br.com.grupoconexao.msinvolved.services.exceptions;

import java.io.Serial;

public class AuthInvolvedException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -3697415937347215852L;

    public AuthInvolvedException(String msg) {
        super(msg);
    }
}
