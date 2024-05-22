package br.com.grupoconexao.msinvolved.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_responsible")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@EqualsAndHashCode
@Builder
public class Responsible implements Serializable {

    @Serial
    private static final long serialVersionUID = 7382051339840945621L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idResponsible;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "name_tutored_student")
    private String nameTutoredStudent;

    @Column(name = "student_registration", unique = true)
    private String studentRegistration;

    @Column(unique = true)
    private String cpf;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "educational_institution")
    private String educationalInstitution;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
