package br.com.grupoconexao.mscontent.controllers;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.services.MaterialsService;
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
@RequestMapping(value = "/v1/materials")
@RequiredArgsConstructor
public class MaterialsController {

    private final MaterialsService materialsService;

    @PostMapping(value = "/upload")
    ResponseEntity<Void> uploadMaterialsFile(@RequestParam(name = "file")MultipartFile file) {
        materialsService.uploadMaterialsFile(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/{idMaterials}")
    ResponseEntity<MaterialsDTO> getMaterials(@PathVariable Long idMaterials) {
        return ResponseEntity.status(HttpStatus.OK).body(materialsService.getMaterials(idMaterials));
    }
}
