package expert.os.harperdb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    private Container container = Container.INSTANCE;

    @Test
    public void shouldGetHost() {
        Server server = ServerBuilder.of(container.host())
                .withCredentials(container.user(), container.password());


    }

}