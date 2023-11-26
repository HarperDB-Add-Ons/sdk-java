package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Operation to create a schema in HarperDB.
 */
final class CreateSchema extends Operation {

    private final String schema;
    CreateSchema(String schema) {
        super(OperationType.CREATE_SCHEMA);
        this.schema = schema;
    }

    public String getSchema() {
        return schema;
    }
}
