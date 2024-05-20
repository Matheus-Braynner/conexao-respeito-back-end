package br.com.grupoconexao.msbff.msbff.clients.involved.client;

import br.com.grupoconexao.msbff.msbff.clients.involved.dto.ActivityDTO;
import br.com.grupoconexao.msbff.msbff.clients.involved.dto.MaterialsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Component
@FeignClient(name = "ms-content", url = "${ms.content.host}")
public interface ContentClient {

    @PostMapping(value = "/v1/activities/upload")
    void uploadActivitiesFile(@RequestParam(name = "file") MultipartFile file);

    @GetMapping(value = "/v1/activities/{idActivity}")
    ActivityDTO getActivity(@PathVariable Long idActivity);

    @PostMapping(value = "/v1/activities/send-activity")
    void sendStudentActivity(@RequestParam(name = "file") MultipartFile file,
                             @RequestParam(name = "studentRegister") String studentRegister);

    @PostMapping(value = "/v1/materials/upload")
    void uploadMaterialsFile(@RequestParam(name = "file") MultipartFile file);

    @GetMapping(value = "/v1/materials/{idMaterials}")
    MaterialsDTO getMaterials(@PathVariable Long idMaterials);
}
