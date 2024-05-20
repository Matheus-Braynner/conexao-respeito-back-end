package br.com.grupoconexao.msbff.msbff.clients.involved.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ActivityDTO {

    private String fileName;

    private byte[] data;
}
