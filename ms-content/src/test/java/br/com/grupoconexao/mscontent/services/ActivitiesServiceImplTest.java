package br.com.grupoconexao.mscontent.services;

import br.com.grupoconexao.mscontent.clients.involved.client.MSInvolvedClient;
import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import br.com.grupoconexao.mscontent.entities.Activity;
import br.com.grupoconexao.mscontent.mappers.ActivitiesMapper;
import br.com.grupoconexao.mscontent.repositories.ActivitiesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static br.com.grupoconexao.mscontent.dummies.ActivitiesDummy.getActivity;
import static br.com.grupoconexao.mscontent.dummies.ActivitiesDummy.getActivityDTO;
import static br.com.grupoconexao.mscontent.dummies.ActivitiesDummy.getStudentDTO;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ActivitiesServiceImplTest {

    @InjectMocks
    private ActivitiesServiceImpl activitiesService;

    @Mock
    private ActivitiesRepository activitiesRepository;

    @Mock
    private ActivitiesMapper activitiesMapper;

    @Mock
    private MSInvolvedClient msInvolvedClient;

    @Test
    @DisplayName("deve tester uploadActivitiesFile")
    void shouldTestUploadActivitiesFile() {
        MultipartFile file = Mockito.mock(MultipartFile.class);

        activitiesService.uploadActivitiesFile(file);

        Mockito.verify(activitiesRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    @DisplayName("deve testar getActivity")
    void shouldTestGetActivity() {
        Long idActivity = 1L;
        Activity activity = getActivity();

        Mockito.when(activitiesRepository.findById(Mockito.any())).thenReturn(Optional.of(activity));
        Mockito.when(activitiesMapper.toActivityDTO(Mockito.any())).thenReturn(getActivityDTO());

        ActivityDTO response = activitiesService.getActivity(idActivity);

        assertNotNull(response);
        Mockito.verify(activitiesRepository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    @DisplayName("deve testar sendStudentActivity")
    void shouldTestSendStudentActivity() {
        MultipartFile file = Mockito.mock(MultipartFile.class);
        Mockito.when(msInvolvedClient.getStudentByRegister(Mockito.any())).thenReturn(getStudentDTO());

        activitiesService.sendStudentActivity(file, "123456");

        Mockito.verify(msInvolvedClient, Mockito.times(1)).getStudentByRegister(Mockito.any());
        Mockito.verify(activitiesRepository, Mockito.times(1)).save(Mockito.any());
    }
}
