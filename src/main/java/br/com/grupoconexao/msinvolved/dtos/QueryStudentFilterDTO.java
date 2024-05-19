package br.com.grupoconexao.msinvolved.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryStudentFilterDTO {

    private String educationalInstitution;

    @PositiveOrZero
    @Builder.Default
    private int page = 0;

    @Positive
    @Builder.Default
    private int size = 9;

    @Builder.Default
    private String sort = "DESC";
}
