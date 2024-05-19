package br.com.grupoconexao.msinvolved.controllers;


import br.com.grupoconexao.msinvolved.dtos.ComplaintDTO;
import br.com.grupoconexao.msinvolved.dtos.ComplaintFormsDTO;
import br.com.grupoconexao.msinvolved.services.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/complaint")
@RequiredArgsConstructor
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping(value = "/{involvedCpf}")
    public ResponseEntity<ComplaintDTO> registerTeacher(@RequestBody ComplaintFormsDTO complaintFormsDTO,
                                                        @PathVariable String involvedCpf) {
        return ResponseEntity.status(HttpStatus.CREATED).body(complaintService.registerComplaint(complaintFormsDTO, involvedCpf));
    }

    @GetMapping(value = "/{complaintId}")
    public ResponseEntity<ComplaintDTO> getComplaintById(@PathVariable Long complaintId) {
        return ResponseEntity.status(HttpStatus.OK).body(complaintService.getComplaintById(complaintId));
    }
}
