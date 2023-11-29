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

import java.util.List;
import java.util.Objects;

/**
 * Represents the "insert" operation in HarperDB.
 * This operation is used to insert records into a specific table within a specified database.
 */
final class Insert extends Operation{

    @JsonProperty
    private final String database;
    @JsonProperty
    private final String table;
    @JsonProperty
    private final List<?> records;

    /**
     * Constructs a new Insert operation with the specified database, table, and records.
     *
     * @param database The name of the database where records will be inserted.
     * @param table    The name of the table where records will be inserted.
     * @param records  The list of records to be inserted into the table.
     */
    Insert(String database, String table, List<?> records) {
        super(OperationType.INSERT);
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
        Insert insert = (Insert) object;
        return Objects.equals(database, insert.database)
                && Objects.equals(table, insert.table)
                && Objects.equals(records, insert.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, table, records);
    }

    @Override
    public String toString() {
        return "Insert{" +
                "database='" + database + '\'' +
                ", table='" + table + '\'' +
                ", records=" + records +
                '}';
    }
}
