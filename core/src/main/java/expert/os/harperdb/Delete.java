package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;


/**
 * Represents the "delete" operation in HarperDB.
 * This operation is used to delete records from a specific table in a given database based on their IDs.
 *
 * @param <K> The type of the IDs used for record identification.
 */
final class Delete<K> extends Operation {


    @JsonProperty
    private final String database;

    @JsonProperty
    private final String table;

    @JsonProperty
    private final Set<K> ids;

    @JsonProperty("get_attributes")
    private final Set<String> attributes;


    /**
     * Constructs a new Delete operation with the specified database, table, IDs, and attributes.
     *
     * @param database   The name of the database where records will be deleted.
     * @param table      The name of the table where records will be deleted.
     * @param ids        The set of IDs used to identify and delete specific records.
     * @param attributes The set of attributes to delete for each record.
     */
    Delete(String database, String table, Set<K> ids, Set<String> attributes) {
        super(OperationType.DELETE);
        this.database = database;
        this.table = table;
        this.ids = ids;
        this.attributes = attributes;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Delete that = (Delete) object;
        return Objects.equals(database, that.database) && Objects.equals(table, that.table)
                && Objects.equals(ids, that.ids) && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, table, ids, attributes);
    }

    @Override
    public String toString() {
        return "Delete{" +
                "database='" + database + '\'' +
                ", table='" + table + '\'' +
                ", ids=" + ids +
                ", attributes=" + attributes +
                '}';
    }
}
