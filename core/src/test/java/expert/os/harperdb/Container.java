package expert.os.harperdb;

import org.testcontainers.containers.GenericContainer;

import java.util.List;

public enum Container {
    INSTANCE;

    private static final String PASSWORD = "password";
    private static final String USER = "root";
    private final GenericContainer<?> container = new GenericContainer<>("harperdb/harperdb")
            .withExposedPorts(9925).withEnv("HDB_ADMIN_PASSWORD", PASSWORD)
            .withEnv("HDB_ADMIN_USERNAME", USER);

    {
        container.start();
    }

    public String host() {
        return "http://" + container.getContainerIpAddress() + ":" + container.getMappedPort(9925);
    }

    public List<String> envs() {
        return container.getEnv();
    }

    public String user() {
        return USER;
    }
    public String password() {
        return PASSWORD;
    }

}
