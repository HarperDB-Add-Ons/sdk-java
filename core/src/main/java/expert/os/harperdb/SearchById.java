package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

final class SearchById extends Operation{


    @JsonProperty
    private final String database;

    @JsonProperty
    private final String table;

    @JsonProperty
    private final Set<Object> ids;

    @JsonProperty("get_attributes")
    private final Set<String> attributes;

    SearchById(String database, String table, Set<Object> ids, Set<String> attributes) {
        super(OperationType.SEARCH_BY_ID);
        this.database = database;
        this.table = table;
        this.ids = ids;
        this.attributes = attributes;
    }
}
