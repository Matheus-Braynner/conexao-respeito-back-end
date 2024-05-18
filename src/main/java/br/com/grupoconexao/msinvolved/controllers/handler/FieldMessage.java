package br.com.grupoconexao.msinvolved.controllers.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = -5774267332140037740L;

    private String fieldName;
    private String message;
}
