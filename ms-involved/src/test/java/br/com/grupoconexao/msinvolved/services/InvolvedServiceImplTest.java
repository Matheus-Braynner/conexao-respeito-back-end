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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.text.html.Option;
import java.util.Optional;

import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getAuthInvolvedFormsDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getResponsible;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getResponsibleDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getResponsibleFormsDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getStudent;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getStudentDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getStudentFormsDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getTeacher;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getTeacherDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getTeacherFormsDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InvolvedServiceImplTest {

    @InjectMocks
    private InvolvedServiceImpl involvedService;

    @Mock
    private ResponsibleRepository responsibleRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private InvolvedMapper involvedMapper;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @DisplayName("deve testar o registro de um estudante")
    @Test
    void testRegisterStudent() {
        StudentDTO expected = getStudentDTO();

        when(involvedMapper.toStudent(any(StudentFormsDTO.class))).thenReturn(getStudent());
        when(responsibleRepository.findFirstByStudentRegistration(anyString())).thenReturn(null);
        when(studentRepository.save(any())).thenReturn(getStudent());
        when(involvedMapper.toStudentDTO(any(Student.class))).thenReturn(getStudentDTO());

        StudentDTO response = this.involvedService.registerStudent(getStudentFormsDTO());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar a busca de um estudante por matrícula que já existe e lançar exceção")
    @Test
    void testRegisterStudentWithStudentAlreadyExists() {
        when(involvedMapper.toStudent(any(StudentFormsDTO.class))).thenReturn(getStudent());
        when(studentRepository.findByRegistration(anyString())).thenThrow(new CannotCreateInvolvedException("Already exist a student registered!"));

        Assertions.assertThrows(CannotCreateInvolvedException.class,
                () -> this.involvedService.registerStudent(getStudentFormsDTO()));
    }

    @DisplayName("deve testar a busca de um estudante por matrícula")
    @Test
    void testGetStudentByRegister() {
        StudentDTO expected = getStudentDTO();

        when(studentRepository.findByRegistration(anyString())).thenReturn(Optional.of(getStudent()));
        when(involvedMapper.toStudentDTO(any(Student.class))).thenReturn(getStudentDTO());

        StudentDTO studentDTO = this.involvedService.getStudentByRegister("123456");

        assertThat(studentDTO).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar o registro de um professor")
    @Test
    void testRegisterTeacher() {
        TeacherDTO expected = getTeacherDTO();

        when(involvedMapper.toTeacher(any(TeacherFormsDTO.class))).thenReturn(getTeacher());
        when(teacherRepository.save(any())).thenReturn(getTeacher());
        when(involvedMapper.toTeacherDTO(any(Teacher.class))).thenReturn(getTeacherDTO());

        TeacherDTO response = this.involvedService.registerTeacher(getTeacherFormsDTO());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar a busca de um professor por matrícula que já existe e lançar exceção")
    @Test
    void testRegisterTeacherWithTeacherAlreadyExists() {
        when(involvedMapper.toTeacher(any(TeacherFormsDTO.class))).thenReturn(getTeacher());
        when(teacherRepository.findByRegistration(anyString())).thenThrow(new CannotCreateInvolvedException("Already exist a teacher registered!"));

        Assertions.assertThrows(CannotCreateInvolvedException.class,
                () -> this.involvedService.registerTeacher(getTeacherFormsDTO()));
    }

    @DisplayName("deve testar o registro de um responsavel")
    @Test
    void testRegisterResponsible() {
        ResponsibleDTO expected = getResponsibleDTO();

        when(involvedMapper.toResponsible(any(ResponsibleFormsDTO.class))).thenReturn(getResponsible());
        when(responsibleRepository.save(any())).thenReturn(getResponsible());
        when(involvedMapper.toResponsibleDTO(any(Responsible.class))).thenReturn(getResponsibleDTO());

        ResponsibleDTO response = this.involvedService.registerResponsible(getResponsibleFormsDTO());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("Deve testar authInvolvedLogin para estudante")
    @Test
    void testAuthInvolvedLoginStudent() {
        when(studentRepository.findByEmail(anyString())).thenReturn(Optional.of(getStudent()));
        when(bCryptPasswordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(involvedMapper.toStudentDTO(any(Student.class))).thenReturn(getStudentDTO());

        Object response = this.involvedService.authInvolvedForLogin(getAuthInvolvedFormsDTO());

        assertThat(response).isNotNull();
    }

    @DisplayName("Deve testar authInvolvedLogin para professor")
    @Test
    void testAuthInvolvedLoginTeacher() {
        when(teacherRepository.findByEmail(anyString())).thenReturn(Optional.of(getTeacher()));
        when(bCryptPasswordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(involvedMapper.toTeacherDTO(any(Teacher.class))).thenReturn(getTeacherDTO());

        Object response = this.involvedService.authInvolvedForLogin(getAuthInvolvedFormsDTO());

        assertThat(response).isNotNull();
    }

    @DisplayName("Deve testar authInvolvedLogin para responsavel")
    @Test
    void testAuthInvolvedLoginResponsible() {
        when(responsibleRepository.findByEmail(anyString())).thenReturn(Optional.of(getResponsible()));
        when(bCryptPasswordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(involvedMapper.toResponsibleDTO(any(Responsible.class))).thenReturn(getResponsibleDTO());

        Object response = this.involvedService.authInvolvedForLogin(getAuthInvolvedFormsDTO());

        assertThat(response).isNotNull();
    }
}
