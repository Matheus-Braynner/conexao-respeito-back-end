package br.com.grupoconexao.msinvolved.controllers;


import br.com.grupoconexao.msinvolved.entities.Responsible;
import br.com.grupoconexao.msinvolved.entities.Student;
import br.com.grupoconexao.msinvolved.entities.Teacher;
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
    public ResponseEntity<Teacher> insertTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.insertTeacher(teacher));
    }

    @PostMapping(value = "/student")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.insertStudent(student));
    }

    @PostMapping(value = "/responsible")
    public ResponseEntity<Responsible> insertResponsible(@RequestBody Responsible responsible) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involvedService.insertResponsible(responsible));
    }


}
