package br.com.grupoconexao.msinvolved.services;


import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherFormsDTO;
import br.com.grupoconexao.msinvolved.entities.Responsible;
import br.com.grupoconexao.msinvolved.entities.Student;
import br.com.grupoconexao.msinvolved.entities.Teacher;
import br.com.grupoconexao.msinvolved.mappers.InvolvedMapper;
import br.com.grupoconexao.msinvolved.repositories.ResponsibleRepository;
import br.com.grupoconexao.msinvolved.repositories.StudentRepository;
import br.com.grupoconexao.msinvolved.repositories.TeacherRepository;
import br.com.grupoconexao.msinvolved.services.exceptions.CannotCreateInvolvedException;
import br.com.grupoconexao.msinvolved.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvolvedServiceImpl implements InvolvedService {

    private final ResponsibleRepository responsibleRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final InvolvedMapper involvedMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public StudentDTO registerStudent(StudentFormsDTO studentForms) {
        Student formsToStudent = involvedMapper.toStudent(studentForms);
        var existStudent = checkIfAlreadyExistInDatabase(formsToStudent, formsToStudent.getRegistration());

        if (existStudent) {
            throw new CannotCreateInvolvedException("Already exist a student registered!");
        }

        Responsible findResponsibleByStudentRegistration = responsibleRepository
                .findFirstByStudentRegistration(formsToStudent.getRegistration());
        formsToStudent.setResponsible(findResponsibleByStudentRegistration);
        formsToStudent.setPassword(bCryptPasswordEncoder.encode(formsToStudent.getPassword()));
        studentRepository.save(formsToStudent);
        log.info("Student saved: {}", formsToStudent);

        StudentDTO studentDTO = involvedMapper.toStudentDTO(formsToStudent);
        log.info("StudentDTO: {}", studentDTO);

        return studentDTO;
    }

    public TeacherDTO registerTeacher(TeacherFormsDTO teacherForms) {
        Teacher formsToTeacher = involvedMapper.toTeacher(teacherForms);
        var existTeacher = checkIfAlreadyExistInDatabase(formsToTeacher, formsToTeacher.getRegistration());

        if (existTeacher) {
            throw new CannotCreateInvolvedException("Already exist a teacher registered!");
        }

        formsToTeacher.setPassword(bCryptPasswordEncoder.encode(formsToTeacher.getPassword()));
        Teacher saveTeacher = teacherRepository.save(formsToTeacher);
        log.info("Teacher saved: {}", saveTeacher);

        TeacherDTO teacherDTO = involvedMapper.toTeacherDTO(saveTeacher);
        log.info("TeacherDTO: {}", teacherDTO);

        return teacherDTO;
    }

    public ResponsibleDTO registerResponsible(ResponsibleFormsDTO responsibleForms) {
        Responsible formsToResponsible = involvedMapper.toResponsible(responsibleForms);

        formsToResponsible.setPassword(bCryptPasswordEncoder.encode(formsToResponsible.getPassword()));
        Responsible saveResponsible = responsibleRepository.save(formsToResponsible);
        log.info("Responsible saved: {}", saveResponsible);

        associateResponsibleToStudent(formsToResponsible.getStudentRegistration(), saveResponsible);


        ResponsibleDTO responsibleDTO = involvedMapper.toResponsibleDTO(saveResponsible);
        log.info("ResponsibleDTO: {}", responsibleDTO);

        return responsibleDTO;
    }

    private void associateResponsibleToStudent(String studentRegistration, Responsible responsible) {
        try {
            Student associate = studentRepository.findByRegistration(studentRegistration)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found student"));
            associate.setResponsible(responsible);

            studentRepository.save(associate);
        } catch (Exception e) {
            log.error("There is no student to associate");
        }
    }

    private Boolean checkIfAlreadyExistInDatabase(Object obj, String register) {
        if (obj instanceof Student) {
            var student = studentRepository.findByRegistration(register);
            log.info("Student: {}", student);
            return student.isPresent();
        } else {
            var teacher = teacherRepository.findByRegistration(register);
            log.info("Teacher: {}", teacher);
            return teacher.isPresent();
        }
    }
}