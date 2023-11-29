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

import java.net.http.HttpResponse;
import java.util.function.Supplier;

/**
 * Enum representing HTTP status codes.
 * Each constant in this enum corresponds to a specific HTTP status code.
 */
enum HttpStatus implements Supplier<Integer> {
    /**
     * HTTP status code 200 OK.
     */
    OK(200);

    private final int status;

    /**
     * Constructs an HttpStatus enum constant with the specified status code.
     *
     * @param status The HTTP status code.
     */
    HttpStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the integer representation of the HTTP status code.
     *
     * @return The HTTP status code.
     */
    @Override
    public Integer get() {
        return status;
    }

    public boolean isEquals(HttpResponse<?> response) {
        return this.status == response.statusCode();
    }
}
