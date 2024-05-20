package br.com.grupoconexao.msinvolved.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ComplaintFormsDTO {

    @NotNull
    private String educationalInstitution;

    @NotNull
    private String nameAggressor;

    @NotNull
    private String placeViolationOccurred;

    @NotNull
    private String complaintReason;
}
