package br.com.grupoconexao.msinvolved.mappers;

import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.entities.Responsible;
import br.com.grupoconexao.msinvolved.entities.Student;
import br.com.grupoconexao.msinvolved.entities.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

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

public class InvolvedMapperTest {

    InvolvedMapper involvedMapper;

    @BeforeEach
    public void setUp() {
        involvedMapper = Mappers.getMapper(InvolvedMapper.class);
    }

    @DisplayName("deve testar Responsible para ResponsibleDTO")
    @Test
    void testToResponsibleDTO() {
        ResponsibleDTO expected = getResponsibleDTO();

        ResponsibleDTO response = this.involvedMapper.toResponsibleDTO(getResponsible());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar Student para StudentDTO")
    @Test
    void testToStudentDTO() {
        StudentDTO expected = getStudentDTO();

        StudentDTO response = this.involvedMapper.toStudentDTO(getStudent());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar Teacher para TeacherDTO")
    @Test
    void testToTeacherDTO() {
        TeacherDTO expected = getTeacherDTO();

        TeacherDTO response = this.involvedMapper.toTeacherDTO(getTeacher());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar StudentFormsDTO para Student")
    @Test
    void testToStudent() {
        Student expected = getStudent();

        Student response = this.involvedMapper.toStudent(getStudentFormsDTO());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar TeacherFormsDTO para Teacher")
    @Test
    void testToTeacher() {
        Teacher expected = getTeacher();

        Teacher response = this.involvedMapper.toTeacher(getTeacherFormsDTO());

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("deve testar ResponsibleFormsDTO para Responsible")
    @Test
    void testToResponsible() {
        Responsible expected = getResponsible();

        Responsible response = this.involvedMapper.toResponsible(getResponsibleFormsDTO());

        assertThat(response).isNotNull().isEqualTo(expected);
    }
}
