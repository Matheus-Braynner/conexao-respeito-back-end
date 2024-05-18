package br.com.grupoconexao.msinvolved.services;

import br.com.grupoconexao.msinvolved.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleDTO;
import br.com.grupoconexao.msinvolved.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentDTO;
import br.com.grupoconexao.msinvolved.dtos.StudentFormsDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherDTO;
import br.com.grupoconexao.msinvolved.dtos.TeacherFormsDTO;

public interface InvolvedService {

    StudentDTO registerStudent(StudentFormsDTO studentForms);

    TeacherDTO registerTeacher(TeacherFormsDTO teacher);

    ResponsibleDTO registerResponsible(ResponsibleFormsDTO responsible);

    Object authInvolvedForLogin(AuthInvolvedFormsDTO authInvolvedForms);
}
