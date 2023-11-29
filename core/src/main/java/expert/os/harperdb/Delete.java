/*
 *
 * MIT License
 *
 * Copyright (c) 2023 Contributors to the HarperDB
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License, which accompanies
 * this distribution. The full text of the license may be found at
 * https://opensource.org/licenses/MIT.
 *
 * You may elect to redistribute this code under the MIT License.
 *
 * Contributors:
 *
 * Otavio Santana
 */

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



    /**
     * Constructs a new Delete operation with the specified database, table, IDs, and attributes.
     *
     * @param database   The name of the database where records will be deleted.
     * @param table      The name of the table where records will be deleted.
     * @param ids        The set of IDs used to identify and delete specific records.
     */
    Delete(String database, String table, Set<K> ids) {
        super(OperationType.DELETE);
        this.database = database;
        this.table = table;
        this.ids = ids;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Delete<?> delete = (Delete<?>) object;
        return Objects.equals(database, delete.database) && Objects.equals(table, delete.table) && Objects.equals(ids, delete.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, table, ids);
    }

    @Override
    public String toString() {
        return "Delete{" +
                "database='" + database + '\'' +
                ", table='" + table + '\'' +
                ", ids=" + ids +
                '}';
    }
}
