package br.com.grupoconexao.mscontent.services.exceptions;

import java.io.Serial;

public class CannotAttachFileWithDifferentRegistrationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4784118019306768998L;

    public CannotAttachFileWithDifferentRegistrationException(String msg) {
            super(msg);
        }

}
