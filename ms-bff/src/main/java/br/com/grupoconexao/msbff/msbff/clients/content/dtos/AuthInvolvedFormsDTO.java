package br.com.grupoconexao.msbff.msbff.clients.content.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthInvolvedFormsDTO {

    @Email
    private String email;

    @NotNull
    private String password;
}
