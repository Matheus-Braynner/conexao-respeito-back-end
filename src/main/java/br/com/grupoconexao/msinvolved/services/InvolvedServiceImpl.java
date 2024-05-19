package br.com.grupoconexao.msinvolved.services;

import br.com.grupoconexao.msinvolved.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.QueryStudentFilterDTO;
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
import br.com.grupoconexao.msinvolved.services.exceptions.AuthInvolvedException;
import br.com.grupoconexao.msinvolved.services.exceptions.CannotCreateInvolvedException;
import br.com.grupoconexao.msinvolved.services.exceptions.ResourceNotFoundException;
import br.com.grupoconexao.msinvolved.specification.QueryStudentSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvolvedServiceImpl implements InvolvedService {

    private final ResponsibleRepository responsibleRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final InvolvedMapper involvedMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public StudentDTO registerStudent(StudentFormsDTO studentForms) {
        var formsToStudent = involvedMapper.toStudent(studentForms);
        var existStudent = checkIfAlreadyExistInDatabase(formsToStudent, formsToStudent.getRegistration());

        if (existStudent) {
            throw new CannotCreateInvolvedException("Already exist a student registered!");
        }

        var findResponsibleByStudentRegistration = responsibleRepository
                .findFirstByStudentRegistration(formsToStudent.getRegistration());
        formsToStudent.setResponsible(findResponsibleByStudentRegistration);
        formsToStudent.setPassword(bCryptPasswordEncoder.encode(formsToStudent.getPassword()));
        studentRepository.save(formsToStudent);
        log.info("Student saved: {}", formsToStudent);

        var studentDTO = involvedMapper.toStudentDTO(formsToStudent);
        log.info("StudentDTO: {}", studentDTO);

        return studentDTO;
    }

    @Override
    public TeacherDTO registerTeacher(TeacherFormsDTO teacherForms) {
        var formsToTeacher = involvedMapper.toTeacher(teacherForms);
        var existTeacher = checkIfAlreadyExistInDatabase(formsToTeacher, formsToTeacher.getRegistration());

        if (existTeacher) {
            throw new CannotCreateInvolvedException("Already exist a teacher registered!");
        }

        formsToTeacher.setPassword(bCryptPasswordEncoder.encode(formsToTeacher.getPassword()));
        var saveTeacher = teacherRepository.save(formsToTeacher);
        log.info("Teacher saved: {}", saveTeacher);

        var teacherDTO = involvedMapper.toTeacherDTO(saveTeacher);
        log.info("TeacherDTO: {}", teacherDTO);

        return teacherDTO;
    }

    @Override
    public ResponsibleDTO registerResponsible(ResponsibleFormsDTO responsibleForms) {
        var formsToResponsible = involvedMapper.toResponsible(responsibleForms);

        formsToResponsible.setPassword(bCryptPasswordEncoder.encode(formsToResponsible.getPassword()));
        var saveResponsible = responsibleRepository.save(formsToResponsible);
        log.info("Responsible saved: {}", saveResponsible);

        associateResponsibleToStudent(formsToResponsible.getStudentRegistration(), saveResponsible);

        ResponsibleDTO responsibleDTO = involvedMapper.toResponsibleDTO(saveResponsible);
        log.info("ResponsibleDTO: {}", responsibleDTO);

        return responsibleDTO;
    }

    @Override
    public Object authInvolvedForLogin(AuthInvolvedFormsDTO authInvolvedForms) {
        try {
            List<Object> resultList = new ArrayList<>();
            Optional<Student> studentFound = studentRepository.findByEmail(authInvolvedForms.getEmail());
            log.info("Student found: {}", studentFound);

            var teacherFound = teacherRepository.findByEmail(authInvolvedForms.getEmail());
            log.info("Teacher found: {}", teacherFound);

            var responsibleFound = responsibleRepository.findByEmail(authInvolvedForms.getEmail());
            log.info("Responsible found: {}", teacherFound);

            studentFound.ifPresent(resultList::add);
            teacherFound.ifPresent(resultList::add);
            responsibleFound.ifPresent(resultList::add);

            Object authObject = checkEmailAndPasswordToAuth(resultList, authInvolvedForms);
            log.info("Auth object value: {}", authObject);

            return authObject;
        } catch (AuthInvolvedException e) {
            log.error("Email not found in db");
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error");
            throw e;
        }
    }

    @Override
    public List<StudentDTO> getStudentsByEducationalInstitution(QueryStudentFilterDTO filter) {

        Specification<Student> specification = QueryStudentSpecification.findAll(filter);

        Page<Student> page = studentRepository.findAll(specification, PageRequest.of(filter.getPage(), filter.getSize()));

        return page.stream().map(involvedMapper::toStudentDTO).collect(Collectors.toList());
    }

    private Object checkEmailAndPasswordToAuth(List<Object> resultList, AuthInvolvedFormsDTO authInvolvedForms) {
        for (Object o : resultList) {
            if (o instanceof Student student) {
                if (student.getEmail().equals(authInvolvedForms.getEmail())
                        && bCryptPasswordEncoder.matches(authInvolvedForms.getPassword(), student.getPassword())) {
                    return involvedMapper.toStudentDTO(student);
                }
            } else if (o instanceof Teacher teacher) {
                if (teacher.getEmail().equals(authInvolvedForms.getEmail()) &&
                        bCryptPasswordEncoder.matches(authInvolvedForms.getPassword(), teacher.getPassword())) {
                    return involvedMapper.toTeacherDTO(teacher);
                }
            } else {
                Responsible responsible = (Responsible) o;
                if (responsible.getEmail().equals(authInvolvedForms.getEmail()) &&
                        bCryptPasswordEncoder.matches(authInvolvedForms.getPassword(), responsible.getPassword())) {
                    return involvedMapper.toResponsibleDTO(responsible);
                }
            }
        }
       throw new AuthInvolvedException("Email or password wrong!");
    }

    private void associateResponsibleToStudent(String studentRegistration, Responsible responsible) {
        try {
            Student associate = studentRepository.findByRegistration(studentRegistration)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found student"));
            associate.setResponsible(responsible);
            log.info("Student to associate: {}", associate);

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