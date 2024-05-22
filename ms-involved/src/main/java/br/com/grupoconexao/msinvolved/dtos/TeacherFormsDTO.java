package br.com.grupoconexao.msinvolved.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeacherFormsDTO {

    @NotNull
    private String fullname;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String postalCode;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String neighborhood;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String educationalInstitution;

    @NotNull
    private String registration;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    private LocalDate birthDate;
}
