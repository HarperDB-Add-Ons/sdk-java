package expert.os.harperdb;

import java.util.Objects;


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
     * @return A TableIdBuilder instance to continue configuring the table with an ID.
     * @throws NullPointerException if the provided table name is null.
     */
    public TableIdBuilder table(String table) {
        Objects.requireNonNull(table, "table is required");
        return new TableIdBuilder(schema, table, server);
    }

    /**
     * Builder class for configuring the details of the table to be created,
     * including specifying the ID for the table.
     */
    public static class TableIdBuilder {

        private final String schema;
        private final String table;
        private final Server server;

        private TableIdBuilder(String schema, String table, Server server) {
            this.schema = schema;
            this.table = table;
            this.server = server;
        }

        /**
         * Specifies the ID (hash attribute) for the table.
         *
         * @param id The hash attribute for the table.
         * @return A TableBuilder instance to continue configuring the table with additional details.
         * @throws NullPointerException if the provided id is null.
         */
        public TableBuilder id(String id) {
            Objects.requireNonNull(id, "id is required");
            return new TableBuilder(schema, table, server, id);
        }
    }

    /**
     * Builder class for configuring additional details of the table to be created
     * and executing the "create table" operation.
     */
    public static class TableBuilder {
        private final String schema;
        private final String table;
        private final Server server;
        private final String id;

        private TableBuilder(String schema, String table, Server server, String id) {
            this.schema = schema;
            this.table = table;
            this.server = server;
            this.id = id;
        }

        /**
         * Executes the "create table" operation with default data attribute.
         *
         * @return true if the table creation is successful; false otherwise.
         */
        public boolean execute() {
            return server.executeTableCreation(new CreateTable(schema, table, id, "data"));
        }

        /**
         * Executes the "create table" operation with a specified database attribute.
         *
         * @param database The database attribute for the table.
         * @return true if the table creation is successful; false otherwise.
         * @throws NullPointerException if the provided database is null.
         */
        public boolean execute(String database) {
            Objects.requireNonNull(database, "database is required");
            return server.executeTableCreation(new CreateTable(schema, table, id, database));
        }
    }
}