package br.com.grupoconexao.msinvolved.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "tb_responsible")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@EqualsAndHashCode
@Builder
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idResponsible;


    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "nameResponsible")
    private String nameResponsible;

    @Column(name = "nameTutoredStudent")
    private String nameTutoredStudent;

    @Column(name = "studentRegistration")
    private String studentRegistration;

    @CPF
    @Column(unique = true)
    private String cpf;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "neighborhood")
    private String neighborhood;


    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "educationalIntitution")
    private String educationalIntitution;


    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
