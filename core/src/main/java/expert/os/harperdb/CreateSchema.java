package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
