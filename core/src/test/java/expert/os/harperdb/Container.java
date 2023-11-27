package expert.os.harperdb;

public enum Container {
    INSTANCE;

    private final GenericContainer<?> harperDBContainer = new GenericContainer<>("harperdb/hdb")
            .withExposedPorts(9925);

}
