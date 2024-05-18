package br.com.grupoconexao.msinvolved.dtos;

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
public class TeacherDTO {

    private Long idTeacher;

    private String fullname;

    private String email;

    private String postalCode;

    private String address;

    private String city;

    private String neighborhood;

    private String phoneNumber;

    private String educationalIntitution;

    private String registration;

    private LocalDate birthDate;
}
