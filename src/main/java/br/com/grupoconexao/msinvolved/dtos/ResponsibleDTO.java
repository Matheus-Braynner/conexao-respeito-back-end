package br.com.grupoconexao.msinvolved.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponsibleDTO {

    private Long idResponsible;

    private String fullname;

    private LocalDate birthDate;

    private String nameTutoredStudent;

    private String studentRegistration;

    private String postalCode;

    private String address;

    private String city;

    private String neighborhood;

    private String phoneNumber;

    private String educationalIntitution;

    private String email;
}
