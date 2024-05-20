package br.com.grupoconexao.mscontent.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MaterialsDTO {

    private String fileName;

    private byte[] data;
}
