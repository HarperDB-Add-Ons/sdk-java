package expert.os.harperdb;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
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

    @Test
    void shouldReturnEmptyListWhenByteIsNull() {
        List<CreateSchema> schemas = mapper.readValue(null, CreateSchema.class);
        Assertions.assertThat(schemas).isNotNull().isEmpty();
    }

    @Test
    void shouldReturnEmptyListWhenByteIsEmpty() {
        List<CreateSchema> schemas = mapper.readValue(new byte[0], CreateSchema.class);
        Assertions.assertThat(schemas).isNotNull().isEmpty();
    }

    @Test
    void shouldReturnListOfEntitiesFromJSON() {
        String expected = "[{\"id\":\"1\",\"name\":\"Lion\"}, {\"id\":\"2\",\"name\":\"Dog\"}]";
        List<Animal> animals = mapper.readValue(expected.getBytes(), Animal.class);
        Assertions.assertThat(animals).isNotNull().isNotEmpty().hasSize(2)
                .extracting(Animal::id).contains("1", "2");
    }
}