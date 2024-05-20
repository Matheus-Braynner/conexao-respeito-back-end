package br.com.grupoconexao.msbff.msbff.clients.content.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String cpf;

    @NotNull
    private LocalDate birthDate;
}
