package expert.os.harperdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServerTest {

    private final Container container = Container.INSTANCE;

    @Test
    void shouldGetHost() {
        Server server = getServer();

        Assertions.assertNotNull(server);
    }

    @Test
    void shouldCreateSchema() {
        Server server = getServer();

        boolean schema = server.schema("test");
        Assertions.assertTrue(schema);
    }

    @Test
    void shouldNotCreateSchemaDuplicated() {
        Server server = getServer();

        boolean schema = server.schema("duplicated");
        Assertions.assertTrue(schema);
        Assertions.assertFalse(server.schema("duplicated"));
    }

    @Test
    void shouldReturnNPEWhenSchemaIsNull() {
        Server server = getServer();

        Assertions.assertThrows(NullPointerException.class, () -> server.createTable(null));
        Assertions.assertThrows(NullPointerException.class, () -> server.createTable("schema").table(null));
        Assertions.assertThrows(NullPointerException.class, () -> server.createTable("schema").table("table").id(null));
    }

    private Server getServer() {
        return ServerBuilder.of(container.host())
                .withCredentials(container.user(), container.password());
    }

}