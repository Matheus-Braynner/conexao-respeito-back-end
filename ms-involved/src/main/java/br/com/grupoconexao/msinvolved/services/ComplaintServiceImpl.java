package br.com.grupoconexao.msinvolved.services;

import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.dtos.ComplaintFormsDTO;
import br.com.grupoconexao.msinvolved.entities.Complaint;
import br.com.grupoconexao.msinvolved.mappers.ComplaintMapper;
import br.com.grupoconexao.msinvolved.repositories.ComplaintRepository;
import br.com.grupoconexao.msinvolved.repositories.ResponsibleRepository;
import br.com.grupoconexao.msinvolved.repositories.StudentRepository;
import br.com.grupoconexao.msinvolved.repositories.TeacherRepository;
import br.com.grupoconexao.msinvolved.services.exceptions.CpfNotValidForComplaintException;
import br.com.grupoconexao.msinvolved.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    private final ResponsibleRepository responsibleRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final ComplaintMapper complaintMapper;

    @Override
    public ComplaintDTO registerComplaint(ComplaintFormsDTO complaintFormsDTO, String involvedCpf) {

        var formsToComplaint = complaintMapper.toComplaint(complaintFormsDTO);
        log.info("forms to complaint: {}", formsToComplaint);

        Boolean isValidCpf = verifyIfCpfIsValid(involvedCpf);

        if (!isValidCpf) {
            throw new CpfNotValidForComplaintException("Cpf is not valid for register complaint");
        }

        var complaintSaved = complaintRepository.save(formsToComplaint);
        log.info("ComplaintSaved: {}", complaintSaved);

        var complaintDTO = complaintMapper.toComplaintDTO(complaintSaved);
        log.info("complaintDTO: {}", complaintDTO);

        return complaintDTO;
    }

    @Override
    public ComplaintDTO getComplaintById(Long complaintId) {

        var complaintFound = complaintRepository.findById(complaintId)
                .orElseThrow(()-> new ResourceNotFoundException("Complaint not found!"));
        log.info("Complaint: {}", complaintFound);

        var complaintDTO = complaintMapper.toComplaintDTO(complaintFound);
        log.info("to complaintDTO: {}", complaintDTO);

        return complaintDTO;
    }

    private Boolean verifyIfCpfIsValid(String involvedCpf) {
        return Stream.of(
                        studentRepository.findByCpf(involvedCpf),
                        responsibleRepository.findByCpf(involvedCpf),
                        teacherRepository.findByCpf(involvedCpf)
                )
                .anyMatch(Optional::isPresent);
    }
}
