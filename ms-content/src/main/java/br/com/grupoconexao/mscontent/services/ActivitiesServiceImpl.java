package br.com.grupoconexao.mscontent.services;

import br.com.grupoconexao.mscontent.clients.involved.client.MSInvolvedClient;
import br.com.grupoconexao.mscontent.clients.involved.dtos.StudentDTO;
import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import br.com.grupoconexao.mscontent.entities.Activity;
import br.com.grupoconexao.mscontent.mappers.ActivitiesMapper;
import br.com.grupoconexao.mscontent.repositories.ActivitiesRepository;
import br.com.grupoconexao.mscontent.services.exceptions.CannotAttachFileWithDifferentRegistrationException;
import br.com.grupoconexao.mscontent.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ActivitiesServiceImpl implements ActivitiesService {

    private final ActivitiesRepository activitiesRepository;

    private final ActivitiesMapper activitiesMapper;

    private final MSInvolvedClient msInvolvedClient;


    @Override
    public void uploadActivitiesFile(MultipartFile file) {
        try {
            var activity = Activity.builder()
                    .fileName(file.getName())
                    .data(file.getBytes()).build();
            log.info("Activity: {}", activity);
            activitiesRepository.save(activity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ActivityDTO getActivity(Long idActivity) {
        var activity = activitiesRepository.findById(idActivity)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found!"));
        log.info("Activity: {}", activity);

        ActivityDTO activityDTO = activitiesMapper.toActivityDTO(activity);
        log.info("ActivityDTO {}", activityDTO);

        return activityDTO;
    }

    @Override
    public void sendStudentActivity(MultipartFile file, String studentRegister) {

       StudentDTO studentByRegister = msInvolvedClient.getStudentByRegister(studentRegister);
       if (studentRegister.equals(studentByRegister.getRegistration())) {
           try {
               Activity activity = Activity.builder()
                       .fileName(file.getName())
                       .data(file.getBytes()).build();
               activitiesRepository.save(activity);
           } catch (IOException e) {
               throw new RuntimeException();
           }
       } else {
           throw new CannotAttachFileWithDifferentRegistrationException("Different student register");
       }
    }
}
