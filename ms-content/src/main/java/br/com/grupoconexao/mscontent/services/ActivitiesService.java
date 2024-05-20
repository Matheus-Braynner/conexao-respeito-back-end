package br.com.grupoconexao.mscontent.services;

import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ActivitiesService {

    void uploadActivitiesFile(MultipartFile file);

    ActivityDTO getActivity(Long idActivity);

    void sendStudentActivity(MultipartFile file, String studentRegister);
}
