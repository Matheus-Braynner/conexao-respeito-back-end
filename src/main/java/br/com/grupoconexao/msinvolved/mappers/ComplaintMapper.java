package br.com.grupoconexao.msinvolved.mappers;

import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.dtos.ComplaintFormsDTO;
import br.com.grupoconexao.msinvolved.entities.Complaint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {

    Complaint toComplaint(ComplaintFormsDTO complaintFormsDTO);

    ComplaintDTO toComplaintDTO(Complaint complaintSaved);

}
