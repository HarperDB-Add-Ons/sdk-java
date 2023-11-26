package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.function.Supplier;

/**
 * Enum representing different operations supported by HarperDB.
 */
public enum OperationType implements Supplier<String> {

    /**
     * Operation to create a schema in HarperDB.
     */
    CREATE_SCHEMA("create_schema"),

    /**
     * Operation to create a table in HarperDB.
     */
    CREATE_TABLE("create_table"),

    /**
     * Operation to insert data into a HarperDB table.
     */
    INSERT("insert"),

    /**
     * Operation to update existing data in a HarperDB table.
     */
    UPDATE("update"),

    /**
     * Operation to insert or update data in a HarperDB table based on existence.
     */
    UPSERT("upsert"),

    /**
     * Operation to delete data from a HarperDB table.
     */
    DELETE("delete"),

    /**
     * Operation to search for a record by its unique identifier in a HarperDB table.
     */
    SEARCH_BY_ID("search_by_id"),

    /**
     * Operation to search for records based on their field values in a HarperDB table.
     */
    SEARCH_BY_VALUE("search_by_value");

    private final String operation;

    /**
     * Constructor for OperationType enum.
     *
     * @param operation The string representation of the operation.
     */
    OperationType(String operation) {
        this.operation = operation;
    }

    /**
     * Gets the string representation of the operation.
     *
     * @return The string representation of the operation.
     */
    @Override
    public String get() {
        return operation;
    }
}
