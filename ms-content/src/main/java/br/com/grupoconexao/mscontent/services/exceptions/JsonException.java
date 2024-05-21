package br.com.grupoconexao.mscontent.services.exceptions;

import java.io.Serial;

public class JsonException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -236769182259138217L;

    public JsonException(Throwable cause) {
        super(cause);
    }

    public JsonException(String message) {
        super(message);
    }
}
