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

    /**
     * Constructs a new CreateTable operation with the specified schema, table, and ID.
     *
     * @param schema The name of the schema for the new table.
     * @param table  The name of the table to be created.
     * @param id     The hash attribute for the new table.
     */
    CreateTable(String schema, String table, String id) {
        super(OperationType.CREATE_TABLE);
        this.schema = schema;
        this.table = table;
        this.id = id;
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
                && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, table, id);
    }

    @Override
    public String toString() {
        return "CreateTable{" +
                "schema='" + schema + '\'' +
                ", table='" + table + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
