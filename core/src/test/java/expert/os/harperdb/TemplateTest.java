package expert.os.harperdb;

import net.datafaker.Faker;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class TemplateTest {

    private Template template;

    private static final Faker FAKER = new Faker();

    @BeforeEach
    void setUp() {
        Container container = Container.INSTANCE;
        Server server = container.getServer();
        server.createDatabase("zoo");
        server.createTable("animal").id("id").database("zoo");
        template = server.template("zoo");
    }

    @ParameterizedTest
    @MethodSource("animal")
    void shouldCreateAnimal(Animal animal){
       Assertions.assertThat(template.insert(animal)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("animals")
    void shouldUpsertAnimal(List<Animal> animals){
        Assertions.assertThat(template.upsert(animals)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("animal")
    void shouldUpsertAnimal(Animal animal){
        Assertions.assertThat(template.upsert(animal)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("animals")
    void shouldCreateAnimal(List<Animal> animals){
        Assertions.assertThat(template.insert(animals)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("animal")
    void shouldFindById(Animal animal){
        template.insert(animal);
        Optional<Animal> optional = template.findById(animal.id(), Animal.class);
        Assertions.assertThat(optional).isPresent();
        Animal entity = optional.orElseThrow();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(entity.id()).isEqualTo(animal.id());
            softly.assertThat(entity.name()).isEqualTo(animal.name());
        });
    }

    @ParameterizedTest
    @MethodSource("animal")
    void shouldReturnEmptyOptionalWhenNotFound(Animal animal){
        Optional<Animal> optional = template.findById(animal, Animal.class);
        Assertions.assertThat(optional).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("animals")
    void shouldFindAllById(List<Animal> animals){
        template.insert(animals);
        var ids = animals.stream().map(Animal::id).toList();
        List<Animal> entities = template.findAllById(ids, Animal.class);
        Assertions.assertThat(entities).hasSize(animals.size());
    }

    static Stream<Arguments> animal(){
        return Stream.of(Arguments.of(new Animal(FAKER.idNumber().valid(), FAKER.animal().name())));
    }

    static Stream<Arguments> animals(){
        List<Animal> animals = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            animals.add(new Animal(FAKER.idNumber().valid(), FAKER.animal().name()));
        }
        return Stream.of(Arguments.of(animals));
    }
}
