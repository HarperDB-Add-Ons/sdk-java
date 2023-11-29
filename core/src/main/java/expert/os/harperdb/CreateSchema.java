package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the "create schema" operation in HarperDB.
 */
final class CreateSchema extends Operation {

    @JsonProperty
    private final String schema;
    CreateSchema(String schema) {
        super(OperationType.CREATE_SCHEMA);
        this.schema = schema;
    }

    /**
     * Gets the name of the schema associated with this operation.
     *
     * @return The schema name.
     */

    public String schema() {
        return schema;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CreateSchema that = (CreateSchema) object;
        return Objects.equals(schema, that.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(schema);
    }

    @Override
    public String toString() {
        return "CreateSchema{" +
                "schema='" + schema + '\'' +
                '}';
    }
}
