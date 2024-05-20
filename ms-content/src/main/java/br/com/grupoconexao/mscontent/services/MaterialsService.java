package br.com.grupoconexao.mscontent.services;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import org.springframework.web.multipart.MultipartFile;

public interface MaterialsService {

    void uploadMaterialsFile(MultipartFile file);

    MaterialsDTO getMaterials(Long idMaterials);
}
