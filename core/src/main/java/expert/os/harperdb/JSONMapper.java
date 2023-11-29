package expert.os.harperdb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

enum JSONMapper {
    INSTANCE;
private final ObjectMapper mapper;
    {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    byte[] writeValueAsBytes(Object value) {
        try {
            return mapper.writeValueAsBytes(value);
        } catch (JsonProcessingException exception) {
            throw new HarperDBException("There is an issue to write to json value", exception);
        }
    }

    <T> Optional<T> readSingleValue(byte[] bytes, Class<T> type) {
        try {
            if(bytes == null || bytes.length == 0){
                return Optional.empty();
            }
            return Optional.of(mapper.readValue(bytes, type));
        } catch (IOException exception) {
            throw new HarperDBException("There is an issue to read from json value", exception);
        }
    }

    <T> List<T> readValue(byte[] bytes, Class<T> type) {
        try {
            if(bytes == null || bytes.length == 0){
                return Collections.emptyList();
            }
            return mapper.readValue(bytes, new TypeReference<>() {});
        } catch (IOException exception) {
            throw new HarperDBException("There is an issue to read from json value", exception);
        }
    }
}
