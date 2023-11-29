package expert.os.harperdb;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JSONMapperTest {
    private final JSONMapper mapper = JSONMapper.INSTANCE;

    @Test
    public void shouldWriteValueAsBytes() {
        byte[] bytes = mapper.writeValueAsBytes(new CreateSchema("test"));
        String expected = "{\"operation\":\"create_schema\",\"schema\":\"test\"}";
        assertEquals(expected, new String(bytes));
    }

    @Test
    void shouldReturnEmptyWhenByteIsNull() {
        Optional<CreateSchema> schema = mapper.readSingleValue(null, CreateSchema.class);
        assertFalse(schema.isPresent());
    }

    @Test
    void shouldReturnEmptyWhenByteIsEmpty() {
        Optional<CreateSchema> schema = mapper.readSingleValue(new byte[0], CreateSchema.class);
        assertFalse(schema.isPresent());
    }

    @Test
    void shouldReturnEntityFromJSON() {
        String expected = "{\"id\":\"123\",\"name\":\"test\"}";
        Optional<Animal> optional = mapper.readSingleValue(expected.getBytes(), Animal.class);
        assertTrue(optional.isPresent());
        Animal schema = optional.orElseThrow();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(schema.id()).isEqualTo("123");
            softly.assertThat(schema.name()).isEqualTo("test");
        });
    }
}