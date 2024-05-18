package br.com.grupoconexao.msinvolved.dtos;

import br.com.grupoconexao.msinvolved.entities.Responsible;
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

    private Responsible responsible;

    private String registration;

    private String postalCode;

    private String address;

    private String city;

    private String neighborhood;

    private String phoneNumber;

    private String educationalIntitution;

    private String email;
}
