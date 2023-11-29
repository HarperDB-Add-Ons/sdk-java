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

import java.net.URI;
import java.util.Objects;

/**
 * The initial configuration point for the HarperDB client.
 */
public final class ServerBuilder {
    private final URI host;
    private ServerBuilder(URI host) {
        this.host = host;
    }

    /**
     * Defines the credentials to be used for the HarperDB instance.
     *
     * @param username the username to be used for the HarperDB instance.
     * @param password the password to be used for the HarperDB instance.
     * @return an initial configuration of the builder.
     * @throws NullPointerException if username or password is null.
     */
    public Server withCredentials(String username, String password){
        Objects.requireNonNull(username, "username must not be null");
        Objects.requireNonNull(password, "password must not be null");
        Auth auth = Auth.of(username, password);
        return Server.of(host, auth);
    }

    /**
     * Defines the host of the HarperDB instance.
     *
     * @param uri the host of the HarperDB instance. E.g.: <a href="http://localhost:9925">http://localhost:9925</a>.
     * @return an initial configuration of the builder.
     * @throws NullPointerException if uri is null.
     */
    public static ServerBuilder of(String uri){
        Objects.requireNonNull(uri, "uri must not be null");
        return new ServerBuilder(URI.create(uri));
    }
}
