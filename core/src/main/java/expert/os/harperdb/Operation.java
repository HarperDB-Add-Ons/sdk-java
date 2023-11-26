package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.function.Supplier;

public enum Operation implements Supplier<String> {
    CREATE_TABLE("create_table");

    private final String operation;
    Operation(String operation) {
        this.operation = operation;
    }

    @Override
    @JsonValue
    public String get() {
        return operation;
    }
}
