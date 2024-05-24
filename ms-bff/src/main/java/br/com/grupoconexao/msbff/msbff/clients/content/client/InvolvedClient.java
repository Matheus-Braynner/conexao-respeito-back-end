package br.com.grupoconexao.msbff.msbff.clients.content.client;

import br.com.grupoconexao.msbff.msbff.clients.content.dtos.AuthInvolvedFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ComplaintDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ComplaintFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ResponsibleDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.ResponsibleFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.StudentDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.StudentFormsDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.TeacherDTO;
import br.com.grupoconexao.msbff.msbff.clients.content.dtos.TeacherFormsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "ms-involved", url = "${ms.involved.host}")
public interface InvolvedClient {

    @PostMapping(value = "/v1/involved/teacher")
    TeacherDTO registerTeacher(@RequestBody TeacherFormsDTO teacherForms);

    @PostMapping(value = "/v1/involved/student")
    StudentDTO registerStudent(@RequestBody StudentFormsDTO studentForms);

    @GetMapping(value = "/v1/involved/student/{studentRegister}")
    StudentDTO getStudentByRegister(@PathVariable String studentRegister);

    @PostMapping(value = "/v1/involved/responsible")
    ResponsibleDTO registerResponsible(@RequestBody ResponsibleFormsDTO responsibleForms);

    @PostMapping(value = "/v1/involved/auth/login")
    Object loginAuth(@RequestBody AuthInvolvedFormsDTO authInvolvedFormsDTO);

    @GetMapping(value = "/v1/involved/student/educational-institution")
    List<StudentDTO> getStudentsByEducationalInstitution
            (@RequestParam(name = "educationalInstitution") String educationalInstitution,
             @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
             @RequestParam(name = "size", required = false, defaultValue = "9") Integer size,
             @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort);

    @PostMapping(value = "/v1/complaint/{involvedCpf}")
    ComplaintDTO registerComplaint(@RequestBody ComplaintFormsDTO complaintFormsDTO,
                                   @PathVariable String involvedCpf);

    @GetMapping(value = "/v1/complaint/{complaintId}")
    ComplaintDTO getComplaintById(@PathVariable Long complaintId);
}
