package expert.os.harperdb;

import java.util.Objects;

/**
 * Builder class for constructing a "create table" operation in HarperDB.
 * This class facilitates the step-by-step configuration of a new table within a specific database.
 */
public final class CreateTableBuilder {

    private final String table;
    private final Server server;

    /**
     * Constructs a CreateTableBuilder instance with the specified table name and server.
     *
     * @param table  The name of the table to be created.
     * @param server The Server instance used for executing HarperDB operations.
     */
    CreateTableBuilder(String table, Server server) {
        this.table = table;
        this.server = server;
    }

    /**
     * Specifies the hash attribute (id) for the table.
     *
     * @param id The hash attribute for the table.
     * @return A TableIdBuilder instance to continue configuring the table with additional details.
     * @throws NullPointerException if the provided id is null.
     */
    public TableIdBuilder id(String id) {
        Objects.requireNonNull(id, "id is required");
        return new TableIdBuilder(id, table, server);
    }

    /**
     * Builder class for configuring additional details of the table to be created
     * and executing the "create table" operation.
     */
    public static class TableIdBuilder {

        private static final String DEFAULT_DATABASE_NAME = "data";
        private final String id;
        private final String table;
        private final Server server;

        private TableIdBuilder(String id, String table, Server server) {
            this.id = id;
            this.table = table;
            this.server = server;
        }

        /**
         * Executes the "create table" operation with default "data" for the database attribute.
         *
         * @return true if the table creation is successful; false otherwise.
         */
        public boolean execute() {
            return server.executeTableCreation(new CreateTable(table, id, DEFAULT_DATABASE_NAME));
        }

        /**
         * Executes the "create table" operation with a specified database attribute.
         *
         * @param database The database attribute for the table.
         * @return true if the table creation is successful; false otherwise.
         * @throws NullPointerException if the provided database is null.
         */
        public boolean database(String database) {
            Objects.requireNonNull(database, "database is required");
            return server.executeTableCreation(new CreateTable(table, id, database));
        }
    }
}
