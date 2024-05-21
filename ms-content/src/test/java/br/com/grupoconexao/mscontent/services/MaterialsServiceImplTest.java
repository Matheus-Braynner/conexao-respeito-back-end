package br.com.grupoconexao.mscontent.services;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.entities.Materials;
import br.com.grupoconexao.mscontent.mappers.MaterialsMapper;
import br.com.grupoconexao.mscontent.repositories.MaterialsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static br.com.grupoconexao.mscontent.dummies.MaterialsDummy.getMaterials;
import static br.com.grupoconexao.mscontent.dummies.MaterialsDummy.getMaterialsDTO;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MaterialsServiceImplTest {

    @InjectMocks
    private MaterialsServiceImpl materialsService;

    @Mock
    private MaterialsRepository materialsRepository;

    @Mock
    private MaterialsMapper materialsMapper;

    @Test
    @DisplayName("deve testar uploadMaterialsFile")
    void shouldTestUploadMaterialsFile() {
        MultipartFile file = Mockito.mock(MultipartFile.class);

        materialsService.uploadMaterialsFile(file);

        Mockito.verify(materialsRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    @DisplayName("deve testar getMaterials")
    void shouldTestGetMaterials() {
        Long idMaterials = 1L;
        Materials materials = getMaterials();

        when(materialsRepository.findById(Mockito.any())).thenReturn(Optional.of(materials));
        when(materialsMapper.toMaterialsDTO(Mockito.any())).thenReturn(getMaterialsDTO());


        MaterialsDTO response = materialsService.getMaterials(idMaterials);

        assertNotNull(response);
        Mockito.verify(materialsRepository, Mockito.times(1)).findById(Mockito.any());
    }
}
