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

/**
 * Abstract class representing a generic operation in HarperDB.
 */
abstract class Operation {

    @JsonProperty
    private final OperationType operation;

    /**
     * Constructs a new Operation with the specified operation type.
     *
     * @param operation The type of the operation.
     */
    Operation(OperationType operation) {
        this.operation = operation;
    }

    /**
     * Gets the type of the operation.
     *
     * @return The operation type.
     */

    public OperationType operation() {
        return operation;
    }
}
