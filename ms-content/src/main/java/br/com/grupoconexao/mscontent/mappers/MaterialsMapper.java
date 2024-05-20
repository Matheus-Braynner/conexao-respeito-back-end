package br.com.grupoconexao.mscontent.mappers;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.entities.Materials;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialsMapper {

    MaterialsDTO toMaterialsDTO(Materials materials);
}
