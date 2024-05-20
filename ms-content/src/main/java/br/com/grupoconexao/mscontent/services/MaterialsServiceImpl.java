package br.com.grupoconexao.mscontent.services;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.entities.Materials;
import br.com.grupoconexao.mscontent.mappers.MaterialsMapper;
import br.com.grupoconexao.mscontent.repositories.MaterialsRepository;
import br.com.grupoconexao.mscontent.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class MaterialsServiceImpl implements MaterialsService {

    private final MaterialsRepository materialsRepository;

    private final MaterialsMapper materialsMapper;

    @Override
    public void uploadMaterialsFile(MultipartFile file) {
        try {
        var materials = Materials.builder()
                .fileName(file.getName())
                .data(file.getBytes()).build();
        log.info("Materials: {}", materials);

        materialsRepository.save(materials);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MaterialsDTO getMaterials(Long idMaterials) {
        var materials = materialsRepository.findById(idMaterials)
                .orElseThrow(() -> new ResourceNotFoundException("Materials not found!"));
        log.info("Materials: {}", materials);

        MaterialsDTO materialsDTO = materialsMapper.toMaterialsDTO(materials);
        log.info("MaterialsDTO: {}", materialsDTO);

        return materialsDTO;
    }
}
