package br.com.grupoconexao.msinvolved.controllers;


import br.com.grupoconexao.msinvolved.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherFormsDTO;
import br.com.grupoconexao.msinvolved.services.InvolvedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/involved")
@RequiredArgsConstructor
public class InvolvedController {

    private final InvolvedService involvedService;

    @PostMapping(value = "/teacher")
    public ResponseEntity<TeacherDTO> registerTeacher(@RequestBody TeacherFormsDTO teacher) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.registerTeacher(teacher));
    }

    @PostMapping(value = "/student")
    public ResponseEntity<StudentDTO> registerStudent(@RequestBody StudentFormsDTO studentForms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.registerStudent(studentForms));
    }

    @PostMapping(value = "/responsible")
    public ResponseEntity<ResponsibleDTO> registerResponsible(@RequestBody ResponsibleFormsDTO responsible) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.registerResponsible(responsible));
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<Object> loginAuth(@RequestBody AuthInvolvedFormsDTO authInvolvedFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(involvedService.authInvolvedForLogin(authInvolvedFormsDTO));
    }
}
