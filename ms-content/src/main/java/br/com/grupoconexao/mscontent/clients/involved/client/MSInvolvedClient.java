package br.com.grupoconexao.mscontent.clients.involved.client;

import br.com.grupoconexao.mscontent.clients.involved.dtos.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-involved", url = "${ms.involved.host}")
public interface MSInvolvedClient {

    @GetMapping(value = "v1/involved/student/{studentRegister}")
    StudentDTO getStudentByRegister(@PathVariable String studentRegister);
}
