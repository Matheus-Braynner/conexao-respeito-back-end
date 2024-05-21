package br.com.grupoconexao.msinvolved.services;

import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.mappers.ComplaintMapper;
import br.com.grupoconexao.msinvolved.repositories.ComplaintRepository;
import br.com.grupoconexao.msinvolved.repositories.ResponsibleRepository;
import br.com.grupoconexao.msinvolved.repositories.StudentRepository;
import br.com.grupoconexao.msinvolved.repositories.TeacherRepository;
import br.com.grupoconexao.msinvolved.services.exceptions.CpfNotValidForComplaintException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.grupoconexao.msinvolved.dummies.ComplaintDummy.getComplaint;
import static br.com.grupoconexao.msinvolved.dummies.ComplaintDummy.getComplaintDTO;
import static br.com.grupoconexao.msinvolved.dummies.ComplaintDummy.getComplaintFormsDTO;
import static br.com.grupoconexao.msinvolved.dummies.InvolvedDummy.getStudent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComplaintServiceImplTest {

    @InjectMocks
    private ComplaintServiceImpl complaintServiceImpl;

    @Mock
    private ComplaintRepository complaintRepository;

    @Mock
    private ResponsibleRepository responsibleRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private ComplaintMapper complaintMapper;

    @DisplayName("faça um registro de uma reclamação")
    @Test
    void registerComplaint() {
        ComplaintDTO expected = getComplaintDTO();

        when(complaintMapper.toComplaint(any())).thenReturn(getComplaint());
        when(studentRepository.findByCpf(anyString())).thenReturn(Optional.of(getStudent()));
        when(complaintRepository.save(any())).thenReturn(getComplaint());
        when(complaintMapper.toComplaintDTO(any())).thenReturn(getComplaintDTO());

        ComplaintDTO response = this.complaintServiceImpl.registerComplaint(getComplaintFormsDTO(), "12345678910");

        assertThat(response).isNotNull().isEqualTo(expected);
    }

    @DisplayName("faça um registro de uma reclamação lançar uma exceção de cpf inválido")
    @Test
    void registerComplaintThrowsException() {
        when(complaintMapper.toComplaint(any())).thenReturn(getComplaint());

        assertThrows(CpfNotValidForComplaintException.class, () ->
                this.complaintServiceImpl.registerComplaint(getComplaintFormsDTO(), "12345678910"));
    }

    @DisplayName("obtenha uma reclamação por id")
    @Test
    void getComplaintById() {
        ComplaintDTO expected = getComplaintDTO();

        when(complaintRepository.findById(any())).thenReturn(Optional.of(getComplaint()));
        when(complaintMapper.toComplaintDTO(any())).thenReturn(getComplaintDTO());

        ComplaintDTO response = this.complaintServiceImpl.getComplaintById(1L);

        assertThat(response).isNotNull().isEqualTo(expected);
    }
}
