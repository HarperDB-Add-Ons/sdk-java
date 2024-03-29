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
 * Represents the "search by ID" operation in HarperDB.
 * This operation is used to retrieve records from a specific table in a given database based on their IDs.
 *
 *  @param <K> The type of the IDs used for record identification.
 */
final class SearchById<K> extends Operation {


    @JsonProperty
    private final String database;

    @JsonProperty
    private final String table;

    @JsonProperty
    private final Set<K> ids;

    @JsonProperty("get_attributes")
    private final Set<String> attributes;

    /**
     * Constructs a new SearchById operation with the specified database, table, IDs, and attributes.
     *
     * @param database   The name of the database where records will be searched.
     * @param table      The name of the table where records will be searched.
     * @param ids        The set of IDs used to identify and retrieve specific records.
     * @param attributes The set of attributes to retrieve for each record.
     */
    SearchById(String database, String table, Set<K> ids, Set<String> attributes) {
        super(OperationType.SEARCH_BY_ID);
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
        SearchById that = (SearchById) object;
        return Objects.equals(database, that.database) && Objects.equals(table, that.table)
                && Objects.equals(ids, that.ids) && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, table, ids, attributes);
    }

    @Override
    public String toString() {
        return "SearchById{" +
                "database='" + database + '\'' +
                ", table='" + table + '\'' +
                ", ids=" + ids +
                ", attributes=" + attributes +
                '}';
    }
}
