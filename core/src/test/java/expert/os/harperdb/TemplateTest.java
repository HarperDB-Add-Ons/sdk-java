package expert.os.harperdb;

import org.junit.jupiter.api.Test;

class TemplateTest {

    private Template template;

    @Test
    void setUp() {
        Container container = Container.INSTANCE;
        Server server = container.getServer();
        server.createDatabase("zoo");
        server.createTable("animal").id("id").database("zoo");
        template = server.template("zoo");
    }
}
