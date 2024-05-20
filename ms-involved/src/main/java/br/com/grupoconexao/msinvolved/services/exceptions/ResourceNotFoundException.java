package br.com.grupoconexao.msinvolved.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -3697415937347215852L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
