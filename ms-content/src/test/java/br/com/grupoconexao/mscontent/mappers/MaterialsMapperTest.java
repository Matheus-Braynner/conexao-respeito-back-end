package br.com.grupoconexao.mscontent.mappers;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.entities.Materials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static br.com.grupoconexao.mscontent.dummies.MaterialsDummy.getMaterials;
import static br.com.grupoconexao.mscontent.dummies.MaterialsDummy.getMaterialsDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaterialsMapperTest {

    private MaterialsMapper materialsMapper;

    @BeforeEach
    void setUp() {
        materialsMapper = Mappers.getMapper(MaterialsMapper.class);
    }

    @Test
    @DisplayName("deve testar toMaterialsDTO")
    void toMaterialsDTO() {
        Materials materials = getMaterials();
        MaterialsDTO expected = getMaterialsDTO();

        MaterialsDTO response = materialsMapper.toMaterialsDTO(materials);

        assertThat(response).isNotNull().isEqualTo(expected);
        assertEquals(materials.getFileName(), response.getFileName());
        assertArrayEquals(materials.getData(), response.getData());
    }
}
