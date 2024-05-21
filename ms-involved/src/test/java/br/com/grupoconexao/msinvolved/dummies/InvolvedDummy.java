package br.com.grupoconexao.msinvolved.dummies;

import br.com.grupoconexao.msinvolved.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherFormsDTO;
import br.com.grupoconexao.msinvolved.entities.Responsible;
import br.com.grupoconexao.msinvolved.entities.Student;
import br.com.grupoconexao.msinvolved.entities.Teacher;

public class InvolvedDummy {

    public static Responsible getResponsible() {
        return Responsible.builder()
                .fullname("Fulano da Silva")
                .nameTutoredStudent("Ciclano da Silva")
                .studentRegistration("123456")
                .cpf("12345678909")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .password("123456")
                .build();
    }

    public static ResponsibleFormsDTO getResponsibleFormsDTO() {
        return ResponsibleFormsDTO.builder()
                .fullname("Fulano da Silva")
                .nameTutoredStudent("Ciclano da Silva")
                .studentRegistration("123456")
                .cpf("12345678909")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .password("123456")
                .build();
    }

    public static ResponsibleDTO getResponsibleDTO(){
        return ResponsibleDTO.builder()
                .fullname("Fulano da Silva")
                .nameTutoredStudent("Ciclano da Silva")
                .studentRegistration("123456")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .build();
    }

    public static Student getStudent() {
        return Student.builder()
                .fullname("Ciclano da Silva")
                .nameResponsible("Fulano da Silva")
                .registration("123456")
                .cpf("12345678909")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .password("123456")
                .build();
    }

    public static StudentFormsDTO getStudentFormsDTO() {
        return StudentFormsDTO.builder()
                .fullname("Ciclano da Silva")
                .nameResponsible("Fulano da Silva")
                .registration("123456")
                .cpf("12345678909")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .password("123456")
                .build();
    }

    public static StudentDTO getStudentDTO() {
        return StudentDTO.builder()
                .fullname("Ciclano da Silva")
                .nameResponsible("Fulano da Silva")
                .registration("123456")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .build();
    }

    public static Teacher getTeacher() {
        return Teacher.builder()
                .fullname("Beltrano da Silva")
                .cpf("12345678909")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .password("123456")
                .registration("123456")
                .build();
    }

    public static TeacherFormsDTO getTeacherFormsDTO() {
        return TeacherFormsDTO.builder()
                .fullname("Beltrano da Silva")
                .cpf("12345678909")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .password("123456")
                .registration("123456")
                .build();
    }


    public static TeacherDTO getTeacherDTO() {
        return TeacherDTO.builder()
                .fullname("Beltrano da Silva")
                .postalCode("12345678")
                .address("Rua da Silva, 123")
                .city("São Paulo")
                .neighborhood("Vila da Silva")
                .phoneNumber("11912345678")
                .registration("123456")
                .educationalInstitution("Escola da Silva")
                .email("mbraynner@outlook.com")
                .build();
    }

    public static AuthInvolvedFormsDTO getAuthInvolvedFormsDTO() {
        return AuthInvolvedFormsDTO.builder()
                .email("mbraynner@outlook.com")
                .password("123456")
                .build();
    }
}
