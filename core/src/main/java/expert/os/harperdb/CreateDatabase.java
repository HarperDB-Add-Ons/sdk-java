package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CreateDatabase that = (CreateDatabase) object;
        return Objects.equals(database, that.database);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(database);
    }

    @Override
    public String toString() {
        return "CreateDatabase{" +
                "database='" + database + '\'' +
                '}';
    }
}

