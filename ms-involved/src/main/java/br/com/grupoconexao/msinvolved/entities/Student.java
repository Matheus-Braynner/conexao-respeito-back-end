package br.com.grupoconexao.msinvolved.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 4431944315874865590L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idStudent;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "name_responsible")
    private String nameResponsible;

    @OneToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "idResponsible")
    private Responsible responsible;

    @Column(name = "registration", unique = true)
    private String registration;

    @CPF
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

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
