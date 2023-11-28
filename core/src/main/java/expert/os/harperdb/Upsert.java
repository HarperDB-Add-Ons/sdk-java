package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

final class Upsert extends Operation{

    @JsonProperty
    private final String database;
    @JsonProperty
    private final String table;
    @JsonProperty
    private final List<?> records;

    Upsert(String database, String table, List<?> records) {
        super(OperationType.UPSERT);
        this.database = database;
        this.table = table;
        this.records = records;
    }
}
