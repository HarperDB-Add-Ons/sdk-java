package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the "create database" operation in HarperDB.
 */
final class CreateDatabase extends Operation {

    @JsonProperty("database")
    private final String database;

    /**
     * Constructs a new CreateDatabase operation with the specified database name.
     *
     * @param database The name of the database to be created.
     */
    CreateDatabase(String database) {
        super(OperationType.CREATE_DATABASE);
        this.database = database;
    }

    /**
     * Gets the name of the database associated with this operation.
     *
     * @return The database name.
     */
    public String getDatabase() {
        return database;
    }
}

