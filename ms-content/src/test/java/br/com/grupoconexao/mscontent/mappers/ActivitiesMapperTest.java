package br.com.grupoconexao.mscontent.mappers;

import br.com.grupoconexao.mscontent.dtos.ActivityDTO;
import br.com.grupoconexao.mscontent.entities.Activity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static br.com.grupoconexao.mscontent.dummies.ActivitiesDummy.getActivity;
import static br.com.grupoconexao.mscontent.dummies.ActivitiesDummy.getActivityDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivitiesMapperTest {

    ActivitiesMapper activitiesMapper;

    @BeforeEach
    void setUp() {
        this.activitiesMapper = Mappers.getMapper(ActivitiesMapper.class);
    }

    @Test
    @DisplayName("deve testar toActivityDTO")
    void shouldTestToActivityDTO() {
        Activity activity = getActivity();
        ActivityDTO expected = getActivityDTO();

        ActivityDTO response = activitiesMapper.toActivityDTO(activity);

        assertThat(response).isNotNull().isEqualTo(expected);
        assertEquals(expected.getFileName(), response.getFileName());
        assertArrayEquals(expected.getData(), response.getData());
    }
}
