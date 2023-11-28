package expert.os.harperdb;

import org.junit.jupiter.api.Test;

class TemplateTest {

    private Template template;

    @Test
    void setUp() {
        Container container = Container.INSTANCE;
        Server server = container.getServer();
        server.createDatabase("zoos");
        server.createTable()
        template = new Template();
    }
}
