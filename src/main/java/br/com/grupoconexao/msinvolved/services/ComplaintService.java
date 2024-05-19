package br.com.grupoconexao.msinvolved.services;

import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.dtos.ComplaintFormsDTO;

public interface ComplaintService {

    ComplaintDTO registerComplaint(ComplaintFormsDTO complaintFormsDTO, String involvedCpf);

    ComplaintDTO getComplaintById(Long complaintId);
}
