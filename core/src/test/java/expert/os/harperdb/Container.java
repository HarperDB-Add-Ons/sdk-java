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

import org.testcontainers.containers.GenericContainer;

import java.util.List;

public enum Container {
    INSTANCE;

    private static final String PASSWORD = "password";
    private static final String USER = "root";
    private final GenericContainer<?> container = new GenericContainer<>("harperdb/harperdb")
            .withExposedPorts(9925).withEnv("HDB_ADMIN_PASSWORD", PASSWORD)
            .withEnv("HDB_ADMIN_USERNAME", USER);

    {
        container.start();
    }

    public String host() {
        return "http://" + container.getContainerIpAddress() + ":" + container.getMappedPort(9925);
    }

    public List<String> envs() {
        return container.getEnv();
    }

    public String user() {
        return USER;
    }
    public String password() {
        return PASSWORD;
    }

    Server getServer() {
        return ServerBuilder.of(host())
                .withCredentials(user(), password());
    }


}
