package br.com.grupoconexao.msinvolved.mappers;

import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.entities.Complaint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static br.com.grupoconexao.msinvolved.dummies.ComplaintDummy.getComplaint;
import static br.com.grupoconexao.msinvolved.dummies.ComplaintDummy.getComplaintDTO;
import static br.com.grupoconexao.msinvolved.dummies.ComplaintDummy.getComplaintFormsDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class ComplaintMapperTest {

    ComplaintMapper complaintMapper;

    @BeforeEach
    public void setUp() {
        this.complaintMapper = Mappers.getMapper(ComplaintMapper.class);
    }

    @DisplayName("converta um formulário de reclamação para entidade")
    @Test
    public void toComplaint() {
        Complaint expected = getComplaint();

        Complaint response = this.complaintMapper.toComplaint(getComplaintFormsDTO());

        assertThat(response).isEqualTo(expected);
    }

    @DisplayName("converta uma entidade de reclamação para DTO")
    @Test
    public void toComplaintDTO() {
        ComplaintDTO expected = getComplaintDTO();

        ComplaintDTO response = this.complaintMapper.toComplaintDTO(getComplaint());

        assertThat(response).isEqualTo(expected);
    }
}
