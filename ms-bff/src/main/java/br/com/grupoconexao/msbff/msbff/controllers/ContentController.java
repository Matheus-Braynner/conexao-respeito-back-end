package br.com.grupoconexao.msbff.msbff.controllers;

import br.com.grupoconexao.msbff.msbff.clients.involved.client.ContentClient;
import br.com.grupoconexao.msbff.msbff.clients.involved.dto.ActivityDTO;
import br.com.grupoconexao.msbff.msbff.clients.involved.dto.MaterialsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/v1/bff")
@RequiredArgsConstructor
public class ContentController {

    private final ContentClient contentClient;

    @PostMapping(value = "/activities/upload")
    ResponseEntity<Void> uploadActivitiesFile(@RequestParam(name = "file") MultipartFile file) {
        contentClient.uploadActivitiesFile(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/activities/{idActivity}")
    ResponseEntity<ActivityDTO> getActivity(@PathVariable Long idActivity) {
        return ResponseEntity.status(HttpStatus.OK).body(contentClient.getActivity(idActivity));
    }

    @PostMapping(value = "/activities/send-activity")
    ResponseEntity<Void> sendStudentActivity(@RequestParam(name = "file") MultipartFile file,
                             @RequestParam(name = "studentRegister") String studentRegister) {
        contentClient.sendStudentActivity(file, studentRegister);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/materials/upload")
    ResponseEntity<Void> uploadMaterialsFile(@RequestParam(name = "file") MultipartFile file) {
        contentClient.uploadMaterialsFile(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/materials/{idMaterials}")
    ResponseEntity<MaterialsDTO> getMaterials(@PathVariable Long idMaterials) {
        return ResponseEntity.status(HttpStatus.OK).body(contentClient.getMaterials(idMaterials));
    }
}
