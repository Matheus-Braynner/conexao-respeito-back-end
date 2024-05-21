package br.com.grupoconexao.mscontent.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.jboss.logging.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class FileUtils {
    private static final Logger log = Logger.getLogger(FileUtils.class);
    private final String srcMainResources;
    private final JsonUtils jsonUtils;

    public FileUtils(String srcMainResources, JsonUtils jsonUtils) {
        this.srcMainResources = srcMainResources;
        this.jsonUtils        = jsonUtils;
    }

    /**
     * Método para fazer a leitura do arquivo de mock
     * @param fileName Nome do arquivo
     * @return Conteúdo do arquivo
     * @throws IOException Lança exception caso o arquivo seja inválido
     */
    public String getContentFile(String fileName) throws IOException {

        if(Objects.isNull(fileName))
            return null;

        var file = new File(srcMainResources);

        var filePath = Paths.get(file.getAbsolutePath(), fileName);

        var content = Files.readString(filePath);

        log.debug(content);

        return content;
    }

    public Reader getReader(String fileName) throws IOException {

        if(Objects.isNull(fileName))
            throw new IllegalArgumentException("Filename must be not null");

        var file     = new File(srcMainResources);
        var filePath = Paths.get(file.getAbsolutePath(), fileName);

        return new FileReader(filePath.toFile());

    }

    public <T> T getObjectFromJsonFile(String filename, Class<T> valueType) throws IOException {

        this.jsonUtils.writeValueAsStringWithDefaultPrettyPrinter(this.getContentFile(filename));

        var absolutePath = Paths.get(srcMainResources, filename);
        var url          = new URL("file:" + absolutePath);

        return this.jsonUtils.getObjectFromJsonFile(url, valueType);

    }

    public <T> T getListObjectFromJsonFile(String filename, TypeReference<T> valueTypeRef) throws IOException {

        this.jsonUtils.writeValueAsStringWithDefaultPrettyPrinter(this.getContentFile(filename));

        var absolutePath = Paths.get(srcMainResources, filename);
        var url          = new URL("file:" + absolutePath);

        return this.jsonUtils.getListObjectFromJsonFile(url, valueTypeRef);
    }

}
