package expert.os.harperdb;

import java.util.Objects;


/**
 * Builder class for constructing a "create table" operation in HarperDB.
 * This class facilitates the step-by-step configuration of a new table within a specific schema.
 */
public final class CreateTableBuilder {

    private final String schema;
    private final Server server;

    /**
     * Constructs a CreateTableBuilder instance with the specified schema and server.
     *
     * @param schema The name of the schema for the new table.
     * @param server The Server instance used for executing HarperDB operations.
     */
    CreateTableBuilder(String schema, Server server) {
        this.schema = schema;
        this.server = server;
    }

    /**
     * Specifies the name of the table to be created.
     *
     * @param table The name of the table.
     * @return A TableBuilder instance to continue configuring the table.
     * @throws NullPointerException if the provided table name is null.
     */
    public TableBuilder table(String table) {
        Objects.requireNonNull(table, "table is required");
        return new TableBuilder(schema, table, server);
    }

    /**
     * Builder class for configuring the details of the table to be created.
     */
    public static class TableBuilder {

        private final String schema;
        private final String table;
        private final Server server;

        /**
         * Constructs a TableBuilder instance with the specified schema, table, and server.
         *
         * @param schema The name of the schema for the new table.
         * @param table  The name of the table to be created.
         * @param server The Server instance used for executing HarperDB operations.
         */
        private TableBuilder(String schema, String table, Server server) {
            this.schema = schema;
            this.table = table;
            this.server = server;
        }

        /**
         * Specifies the hash attribute (id) for the table.
         *
         * @param id The hash attribute for the table.
         * @return true if the table creation is successful; false otherwise.
         * @throws NullPointerException if the provided id is null.
         */
        public boolean id(String id) {
            Objects.requireNonNull(id, "id is required");
            return this.server.createTable(new CreateTable(schema, table, id));
        }
    }
}
