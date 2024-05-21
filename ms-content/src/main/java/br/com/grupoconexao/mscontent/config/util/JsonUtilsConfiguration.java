package br.com.grupoconexao.mscontent.config.util;

import br.com.grupoconexao.mscontent.util.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonUtilsConfiguration {

    @Bean
    public JsonUtils jsonUtils(ObjectMapper objectMapper){
        return new JsonUtils(objectMapper);
    }
}
