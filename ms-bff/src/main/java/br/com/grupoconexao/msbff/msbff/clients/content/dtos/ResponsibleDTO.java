package br.com.grupoconexao.msbff.msbff.clients.content.dtos;

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

    private String educationalInstitution;

    private String email;
}
