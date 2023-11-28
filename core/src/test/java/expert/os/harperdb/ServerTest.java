package expert.os.harperdb;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    private Container container = Container.INSTANCE;

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

        boolean schema = server.schema("test");
        Assertions.assertTrue(schema);
        Assertions.assertFalse(server.schema("test"));
    }

    private Server getServer() {
        return ServerBuilder.of(container.host())
                .withCredentials(container.user(), container.password());
    }

}