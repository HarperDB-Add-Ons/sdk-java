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

/**
 * Custom exception class for handling exceptions related to HarperDB operations.
 */
public class HarperDBException extends RuntimeException {

    /**
     * Constructs a new HarperDBException with no specified detail message.
     */
    public HarperDBException() {
    }

    /**
     * Constructs a new HarperDBException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public HarperDBException(String message) {
        super(message);
    }

    /**
     * Constructs a new HarperDBException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause   the cause (which is saved for later retrieval by the getCause() method).
     */
    public HarperDBException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new HarperDBException with the specified cause and a detail message of (cause==null ? null : cause.toString())
     * (which typically contains the class and detail message of cause).
     *
     * @param cause the cause (which is saved for later retrieval by the getCause() method).
     */
    public HarperDBException(Throwable cause) {
        super(cause);
    }

}

