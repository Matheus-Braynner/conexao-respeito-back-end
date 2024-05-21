package br.com.grupoconexao.mscontent.dummies;

import br.com.grupoconexao.mscontent.dtos.MaterialsDTO;
import br.com.grupoconexao.mscontent.entities.Materials;

public class MaterialsDummy {

    public static Materials getMaterials() {
        return Materials.builder()
                .id(1L)
                .fileName("Material 1")
                .data("data".getBytes())
                .build();
    }

    public static MaterialsDTO getMaterialsDTO() {
        return MaterialsDTO.builder()
                .fileName("Material 1")
                .data("data".getBytes())
                .build();
    }
}
