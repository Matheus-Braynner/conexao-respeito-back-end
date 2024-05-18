package br.com.grupoconexao.msinvolved.mappers;

import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherFormsDTO;
import br.com.grupoconexao.msinvolved.entities.Responsible;
import br.com.grupoconexao.msinvolved.entities.Student;
import br.com.grupoconexao.msinvolved.entities.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvolvedMapper {

    ResponsibleDTO toResponsibleDTO(Responsible responsible);

    StudentDTO toStudentDTO(Student student);

    TeacherDTO toTeacherDTO(Teacher teacher);

    Student toStudent(StudentFormsDTO student);

    Teacher toTeacher(TeacherFormsDTO teacherForms);

    Responsible toResponsible(ResponsibleFormsDTO responsibleForms);
}
