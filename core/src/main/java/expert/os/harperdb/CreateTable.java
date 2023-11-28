package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the "create table" operation in HarperDB.
 */
final class CreateTable extends Operation {

    @JsonProperty
    private final String schema;

    @JsonProperty
    private final String table;

    @JsonProperty("hash_attribute")
    private final String id;

    @JsonProperty("database")
    private final String database;

    /**
     * Constructs a new CreateTable operation with the specified schema, table, and ID.
     *
     * @param schema The name of the schema for the new table.
     * @param table  The name of the table to be created.
     * @param database The name of the database to be created.
     * @param id     The hash attribute for the new table.
     */
    CreateTable(String schema, String table, String id, String database) {
        super(OperationType.CREATE_TABLE);
        this.schema = schema;
        this.table = table;
        this.id = id;
        this.database = database;
    }

    /**
     * Gets the name of the schema associated with this operation.
     *
     * @return The schema name.
     */
    public String schema() {
        return schema;
    }

    /**
     * Gets the name of the table associated with this operation.
     *
     * @return The table name.
     */
    public String table() {
        return table;
    }

    /**
     * Gets the hash attribute associated with this operation.
     *
     * @return The hash attribute.
     */
    public String id() {
        return id;
    }

    /**
     * Gets the database associated with this operation.
     *
     * @return The database.
     */
    public String database() {
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
        CreateTable that = (CreateTable) object;
        return Objects.equals(schema, that.schema) && Objects.equals(table, that.table)
                && Objects.equals(id, that.id) && Objects.equals(database, that.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, table, id, database);
    }

    @Override
    public String toString() {
        return "CreateTable{" +
                "schema='" + schema + '\'' +
                ", table='" + table + '\'' +
                ", id='" + id + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
