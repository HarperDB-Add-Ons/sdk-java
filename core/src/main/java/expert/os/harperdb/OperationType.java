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

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.function.Supplier;

/**
 * Enum representing different operations supported by HarperDB.
 */
public enum OperationType implements Supplier<String> {

    /**
     * Operation to create a schema in HarperDB.
     */
    CREATE_SCHEMA("create_schema"),

    /**
     * Operation to create a table in HarperDB.
     */
    CREATE_TABLE("create_table"),
    /**
     * Operation to create a database in HarperDB.
     */
    CREATE_DATABASE("create_database"),

    /**
     * Operation to insert data into a HarperDB table.
     */
    INSERT("insert"),

    /**
     * Operation to update existing data in a HarperDB table.
     */
    UPDATE("update"),

    /**
     * Operation to insert or update data in a HarperDB table based on existence.
     */
    UPSERT("upsert"),

    /**
     * Operation to delete data from a HarperDB table.
     */
    DELETE("delete"),

    /**
     * Operation to search for a record by its unique identifier in a HarperDB table.
     */
    SEARCH_BY_ID("search_by_id"),

    /**
     * Operation to search for records based on their field values in a HarperDB table.
     */
    SEARCH_BY_VALUE("search_by_value");

    private final String operation;

    /**
     * Constructor for OperationType enum.
     *
     * @param operation The string representation of the operation.
     */
    OperationType(String operation) {
        this.operation = operation;
    }

    /**
     * Gets the string representation of the operation.
     *
     * @return The string representation of the operation.
     */
    @Override
    @JsonValue
    public String get() {
        return operation;
    }
}
