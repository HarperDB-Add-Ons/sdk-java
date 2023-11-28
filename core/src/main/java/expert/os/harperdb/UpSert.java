package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

final class UpSert extends Operation{

    @JsonProperty
    private final String database;
    @JsonProperty
    private final String table;
    @JsonProperty
    private final List<?> records;

    UpSert(String database, String table, List<?> records) {
        super(OperationType.UPSERT);
        this.database = database;
        this.table = table;
        this.records = records;
    }
}
