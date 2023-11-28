package expert.os.harperdb;

import java.net.http.HttpRequest;
import java.util.Objects;

import static expert.os.harperdb.JSONMapper.INSTANCE;
import static java.net.http.HttpRequest.BodyPublishers.ofByteArray;

public final class CreateTableBuilder {

    private final String schema;

    private final Server server;

    CreateTableBuilder(String schema, Server server) {
        this.schema = schema;
        this.server = server;
    }


    public TableBuilder table(String table) {
        Objects.requireNonNull(table, "table is required");
        return new TableBuilder(schema, table, server);
    }


    public static class TableBuilder {
        private final String schema;
        private final String table;
        private final Server server;
        private TableBuilder(String schema, String table, Server server) {
            this.schema = schema;
            this.table = table;
            this.server = server;
        }
        public boolean id(String id) {
            Objects.requireNonNull(id, "id is required");
            return this.server.createTable(new CreateTable(schema, table, id));
        }
    }

}
