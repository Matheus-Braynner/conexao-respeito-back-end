package br.com.grupoconexao.msbff.msbff.controllers;

import br.com.grupoconexao.msbff.msbff.clients.content.client.InvolvedClient;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ComplaintDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ComplaintFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ResponsibleDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.StudentDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.StudentFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.TeacherDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.TeacherFormsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/bff")
@RequiredArgsConstructor
public class InvolvedController {

    private final InvolvedClient involvedClient;

    @PostMapping(value = "/v1/involved/teacher")
    ResponseEntity<TeacherDTO> registerTeacher(@RequestBody TeacherFormsDTO teacherForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedClient.registerTeacher(teacherForms));
    }

    @PostMapping(value = "/v1/involved/student")
    ResponseEntity<StudentDTO> registerStudent(@RequestBody StudentFormsDTO studentForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedClient.registerStudent(studentForms));
    }

    @GetMapping(value = "/v1/involved/student/{studentRegister}")
    ResponseEntity<StudentDTO> getStudentByRegister(@PathVariable String studentRegister) {
        return ResponseEntity.status(HttpStatus.OK).body(involvedClient.getStudentByRegister(studentRegister));
    }

    @PostMapping(value = "/v1/involved/responsible")
    ResponseEntity<ResponsibleDTO> registerResponsible(@RequestBody ResponsibleFormsDTO responsibleForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedClient.registerResponsible(responsibleForms));
    }

    @PostMapping(value = "/v1/involved/auth/login")
    ResponseEntity<Object> loginAuth(@RequestBody AuthInvolvedFormsDTO authInvolvedFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(involvedClient.loginAuth(authInvolvedFormsDTO));
    }

    @GetMapping(value = "/v1/involved/student/educational-institution")
    ResponseEntity<List<StudentDTO>> getStudentsByEducationalInstitution
            (@RequestParam(name = "educationalInstitution") String educationalInstitution,
             @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
             @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
             @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(involvedClient.getStudentsByEducationalInstitution(educationalInstitution, page, size, sort));
    }

    @PostMapping(value = "/v1/complaint/{involvedCpf}")
    ResponseEntity<ComplaintDTO> registerComplaint(@RequestBody ComplaintFormsDTO complaintFormsDTO,
                                                   @PathVariable String involvedCpf) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedClient.registerComplaint(complaintFormsDTO, involvedCpf));
    }

    @GetMapping(value = "/v1/complaint/{complaintId}")
    ResponseEntity<ComplaintDTO> getComplaintById(@PathVariable Long complaintId) {
        return ResponseEntity.status(HttpStatus.OK).body(involvedClient.getComplaintById(complaintId));
    }
}
