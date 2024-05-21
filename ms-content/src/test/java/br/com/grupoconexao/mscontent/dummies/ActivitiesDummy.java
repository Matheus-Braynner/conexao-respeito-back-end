package br.com.grupoconexao.mscontent.dummies;

import br.com.grupoconexao.mscontent.clients.involved.dtos.StudentDTO;
import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import br.com.grupoconexao.mscontent.entities.Activity;

public class ActivitiesDummy {

    public static Activity getActivity() {
        return Activity.builder()
                .id(1L)
                .fileName("Activity 1")
                .data("data".getBytes())
                .build();
    }

    public static ActivityDTO getActivityDTO() {
        return ActivityDTO.builder()
                .fileName("Activity 1")
                .data("data".getBytes())
                .build();
    }

    public static StudentDTO getStudentDTO() {
        return StudentDTO.builder()
                .idStudent(1L)
                .fullname("Student 1")
                .birthDate(null)
                .nameResponsible("Responsible 1")
                .registration("123456")
                .postalCode("123456")
                .address("Address 1")
                .city("City 1")
                .neighborhood("Neighborhood 1")
                .phoneNumber("123456")
                .educationalInstitution("Institution 1")
                .email("mbraynner@outlook.com")
                .build();
    }
}
