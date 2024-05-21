package br.com.grupoconexao.mscontent.util;

import br.com.grupoconexao.mscontent.services.exceptions.JsonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {

    private static final Logger log = Logger.getLogger(JsonUtils.class);
    private static final String CONTENT_FILE_S = "Content File: %s";
    private final ObjectMapper objectMapper;

    public JsonUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String writeValueAsStringWithDefaultPrettyPrinter(Object value) {
        try {
            var ow          = objectMapper.writer().withDefaultPrettyPrinter();
            var payloadJson = ow.writeValueAsString(value);
            log.infof("%n%n %s %s %n%n", "PAYLOAD_JSON ", payloadJson);
            return payloadJson;
        }
        catch (JsonProcessingException e) {
            throw new JsonException(e);
        }

    }

    public <T> T getObjectFromStringJson(String stringJson, Class<T> valueType) {
        try {
            var readValue = objectMapper.readValue(stringJson, valueType);
            log.infof(CONTENT_FILE_S, readValue);
            return readValue;
        }
        catch (JsonProcessingException e) {
            throw new JsonException(e);
        }
    }

    public <T> T getObjectFromStringJson(String stringJson, TypeReference<T> valueTypeRef) {
        try {
            var readValue = objectMapper.readValue(stringJson, valueTypeRef);
            log.infof(CONTENT_FILE_S, readValue);
            return objectMapper.readValue(stringJson, valueTypeRef);
        }
        catch (JsonProcessingException e) {
            throw new JsonException(e);
        }
    }

    public <T> T getObjectFromJsonFile(URL src, Class<T> valueType) throws IOException {
        var readValue = objectMapper.readValue(src, valueType);

        log.infof(CONTENT_FILE_S, readValue);

        return readValue;
    }

    public <T> T getListObjectFromJsonFile(URL src, TypeReference<T> valueTypeRef) throws IOException {
        var readValue = objectMapper.readValue(src, valueTypeRef);

        log.infof(CONTENT_FILE_S, readValue);

        return readValue;
    }

    public String writeValueAsString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            throw new JsonException(e);
        }
    }

    public <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return objectMapper.convertValue(fromValue, toValueType);
    }

    public <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        return objectMapper.convertValue(fromValue, toValueTypeRef);
    }

    public <T> Map<String, String> map(T request) {

        if (Objects.isNull(request)) {
            return Collections.emptyMap();
        }

        log.infof("Request: %s", request);
        var map = this.convertValue(request, new TypeReference<Map<String, String>>() {});

        log.infof("Map: %s", map);
        return map;
    }
}
