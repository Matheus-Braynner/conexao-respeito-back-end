package br.com.grupoconexao.mscontent.controllers;

import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.services.ActivitiesService;
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
@RequestMapping(value = "/v1/activities")
@RequiredArgsConstructor
public class ActivitiesController {

    private final ActivitiesService activitiesService;

    @PostMapping(value = "/upload")
    ResponseEntity<Void> uploadActivitiesFile(@RequestParam(name = "file")MultipartFile file) {
        activitiesService.uploadActivitiesFile(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/{idActivity}")
    ResponseEntity<ActivityDTO> getActivity(@PathVariable Long idActivity) {
        return ResponseEntity.status(HttpStatus.OK).body(activitiesService.getActivity(idActivity));
    }

    @PostMapping(value = "/send-activity")
    ResponseEntity<Void> sendStudentActivity(@RequestParam(name = "file")MultipartFile file,
                                      @RequestParam(name = "studentRegister") String studentRegister) {
        activitiesService.sendStudentActivity(file, studentRegister);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
