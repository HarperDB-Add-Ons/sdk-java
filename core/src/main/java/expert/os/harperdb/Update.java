package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Represents the "update" operation in HarperDB.
 * This operation is used to update records within a specific table in a given database.
 */
final class Update extends Operation{

    @JsonProperty
    private final String database;
    @JsonProperty
    private final String table;
    @JsonProperty
    private final List<?> records;

    /**
     * Constructs a new Update operation with the specified database, table, and records.
     *
     * @param database The name of the database where records will be updated.
     * @param table    The name of the table where records will be updated.
     * @param records  The list of records containing updates to be applied to the table.
     */
    Update(String database, String table, List<?> records) {
        super(OperationType.UPDATE);
        this.database = database;
        this.table = table;
        this.records = records;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Update update = (Update) object;
        return Objects.equals(database, update.database)
                && Objects.equals(table, update.table)
                && Objects.equals(records, update.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, table, records);
    }

    @Override
    public String toString() {
        return "Update{" +
                "database='" + database + '\'' +
                ", table='" + table + '\'' +
                ", records=" + records +
                '}';
    }
}
