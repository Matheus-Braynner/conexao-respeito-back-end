package br.com.grupoconexao.msinvolved.dummies;

import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.dtos.ComplaintFormsDTO;
import br.com.grupoconexao.msinvolved.entities.Complaint;

public class ComplaintDummy {

    public static Complaint getComplaint() {
        return Complaint.builder()
                .educationalInstitution("Escola da Silva")
                .nameAggressor("Beltrano da Silva")
                .placeViolationOccurred("Rua da Silva, 123")
                .complaintReason("Motivo da denúncia")
                .build();
    }

    public static ComplaintFormsDTO getComplaintFormsDTO() {
        return ComplaintFormsDTO.builder()
                .educationalInstitution("Escola da Silva")
                .nameAggressor("Beltrano da Silva")
                .placeViolationOccurred("Rua da Silva, 123")
                .complaintReason("Motivo da denúncia")
                .build();
    }

    public static ComplaintDTO getComplaintDTO(){
        return ComplaintDTO.builder()
                .educationalInstitution("Escola da Silva")
                .nameAggressor("Beltrano da Silva")
                .placeViolationOccurred("Rua da Silva, 123")
                .complaintReason("Motivo da denúncia")
                .build();
    }
}
