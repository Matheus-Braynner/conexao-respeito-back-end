package br.com.grupoconexao.mscontent.clients.involved.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {

    private Long idStudent;

    private String fullname;

    private LocalDate birthDate;

    private String nameResponsible;

    private String registration;

    private String postalCode;

    private String address;

    private String city;

    private String neighborhood;

    private String phoneNumber;

    private String educationalInstitution;

    private String email;
}
