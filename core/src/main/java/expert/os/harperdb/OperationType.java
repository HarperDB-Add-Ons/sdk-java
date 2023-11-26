package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.function.Supplier;

public enum OperationType implements Supplier<String> {
    CREATE_SCHEMA("create_schema"),
    CREATE_TABLE("create_table"),
    INSERT("insert"),
    UPDATE("update"),
    UPSERT("upsert"),
    DELETE("delete"),
    SEARCH_BY_ID("search_by_id"),
    SEARCH_BY_VALUE("search_by_value");

    private final String operation;
    OperationType(String operation) {
        this.operation = operation;
    }

    @Override
    @JsonValue
    public String get() {
        return operation;
    }
}
