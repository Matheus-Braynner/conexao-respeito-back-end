package br.com.grupoconexao.mscontent.config.util;

import br.com.grupoconexao.mscontent.util.FileUtils;
import br.com.grupoconexao.mscontent.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUtilsConfiguration {

    @Bean
    public FileUtils fileUtils(@Value("${src-main-resources}") String srcMainResources, JsonUtils jsonUtils){
        return new FileUtils(srcMainResources, jsonUtils);
    }
}
