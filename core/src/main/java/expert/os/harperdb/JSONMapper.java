package expert.os.harperdb;

import com.fasterxml.jackson.databind.ObjectMapper;

public enum JSONMapper {
    INSTANCE;
private final ObjectMapper mapper;
    {
        mapper = new ObjectMapper();

    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
