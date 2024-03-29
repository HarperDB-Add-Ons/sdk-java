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

/**
 * Represents the "create table" operation in HarperDB.
 */
final class CreateTable extends Operation {

    @JsonProperty
    private final String table;

    @JsonProperty("hash_attribute")
    private final String id;

    @JsonProperty("database")
    private final String database;

    /**
     * Constructs a new CreateTable operation with the specified schema, table, and ID.
     *
     * @param table  The name of the table to be created.
     * @param database The name of the database to be created.
     * @param id     The hash attribute for the new table.
     */
    CreateTable( String table, String id, String database) {
        super(OperationType.CREATE_TABLE);
        this.table = table;
        this.id = id;
        this.database = database;
    }

    /**
     * Gets the name of the table associated with this operation.
     *
     * @return The table name.
     */
    public String table() {
        return table;
    }

    /**
     * Gets the hash attribute associated with this operation.
     *
     * @return The hash attribute.
     */
    public String id() {
        return id;
    }

    /**
     * Gets the database associated with this operation.
     *
     * @return The database.
     */
    public String database() {
        return database;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CreateTable that = (CreateTable) object;
        return Objects.equals(table, that.table)
                && Objects.equals(id, that.id)
                && Objects.equals(database, that.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, id, database);
    }

    @Override
    public String toString() {
        return "CreateTable{" +
                "table='" + table + '\'' +
                ", id='" + id + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
