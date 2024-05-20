package br.com.grupoconexao.msinvolved.controllers;


import br.com.grupoconexao.msinvolved.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.QueryStudentFilterDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherFormsDTO;
import br.com.grupoconexao.msinvolved.services.InvolvedService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
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
@RequestMapping(value = "/v1/involved")
@RequiredArgsConstructor
public class InvolvedController {

    private final InvolvedService involvedService;

    @PostMapping(value = "/teacher")
    public ResponseEntity<TeacherDTO> registerTeacher(@RequestBody TeacherFormsDTO teacherForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.registerTeacher(teacherForms));
    }

    @PostMapping(value = "/student")
    public ResponseEntity<StudentDTO> registerStudent(@RequestBody StudentFormsDTO studentForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.registerStudent(studentForms));
    }

    @GetMapping(value = "/student/{studentRegister}")
    public ResponseEntity<StudentDTO> getStudentByRegister(@PathVariable String studentRegister) {
        return ResponseEntity.status(HttpStatus.OK).body(involvedService.getStudentByRegister(studentRegister));
    }

    @PostMapping(value = "/responsible")
    public ResponseEntity<ResponsibleDTO> registerResponsible(@RequestBody ResponsibleFormsDTO responsibleForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.registerResponsible(responsibleForms));
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<Object> loginAuth(@RequestBody AuthInvolvedFormsDTO authInvolvedFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(involvedService.authInvolvedForLogin(authInvolvedFormsDTO));
    }

    @GetMapping(value = "/student/educational-institution")
    public ResponseEntity<List<StudentDTO>> getStudentsByEducationalInstitution
            (@RequestParam(name = "educationalInstitution") String educationalInstitution,
             @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
             @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
             @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {

        QueryStudentFilterDTO filter = QueryStudentFilterDTO.builder()
                .educationalInstitution(educationalInstitution)
                .page(page)
                .size(size)
                .sort(sort).build();

        return ResponseEntity.status(HttpStatus.OK)
                .body(involvedService.getStudentsByEducationalInstitution(filter));
    }
}
