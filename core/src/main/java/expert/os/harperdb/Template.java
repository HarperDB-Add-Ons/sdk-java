package expert.os.harperdb;

public final class Template {
    private final String database;
    private final Server server;
    Template(String database, Server server) {

        this.database = database;
        this.server = server;
    }
}
