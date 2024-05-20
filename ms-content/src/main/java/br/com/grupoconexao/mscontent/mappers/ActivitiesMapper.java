package br.com.grupoconexao.mscontent.mappers;

import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import br.com.grupoconexao.mscontent.entities.Activity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivitiesMapper {

    ActivityDTO toActivityDTO(Activity activity);
}