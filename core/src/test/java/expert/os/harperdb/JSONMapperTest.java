package expert.os.harperdb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONMapperTest {
    private JSONMapper mapper = JSONMapper.INSTANCE;
    @Test
    public void shouldWriteValueAsBytes() {
        byte[] bytes = mapper.writeValueAsBytes(new CreateSchema("test"));
        String expected = "{\"operation\":\"create_schema\",\"schema\":\"test\"}";
        assertEquals(expected, new String(bytes));
    }
}