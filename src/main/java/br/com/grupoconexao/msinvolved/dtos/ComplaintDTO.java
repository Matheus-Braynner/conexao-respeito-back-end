package br.com.grupoconexao.msinvolved.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ComplaintDTO {

    private Long idComplaint;

    private String educationalInstitution;

    private String nameAggressor;

    private String placeViolationOccurred;

    private String complaintReason;
}
