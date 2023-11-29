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

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static expert.os.harperdb.JSONMapper.INSTANCE;
import static java.net.http.HttpRequest.BodyPublishers.ofByteArray;

/**
 * Represents a HarperDB server.
 */
public final class Server  {

    private final URI host;
    private final Auth auth;

    private final HttpClient client;

    private Server(URI host, Auth auth) {
        this.host = host;
        this.auth = auth;
        this.client = HttpClient.newBuilder().build();
    }

    static Server of(URI host, Auth auth) {
        return new Server(host, auth);
    }

    /**
     * Create a schema to the database
     * @param schema the schema name
     * @return true if the schema was created, false otherwise
     * @throws NullPointerException if schema is null
     */
    public boolean createSchema(String schema) {
        Objects.requireNonNull(schema, "schema is required");
        return execute(new CreateSchema(schema));
    }

    /**
     * Creates a new database in HarperDB with the specified name.
     *
     * @param database The name of the database to be created.
     * @return true if the database creation is successful; false otherwise.
     * @throws NullPointerException if the provided database name is null.
     * @throws HarperDBException if there is an issue creating the database.
     */
    public boolean createDatabase(String database) {
        Objects.requireNonNull(database, "database is required");
        return execute(new CreateDatabase(database));
    }

    /**
     * Starts the process of building a "create table" operation for a specific database.
     *
     * @param table The name of the new table.
     * @return A CreateTableBuilder instance to further configure the "create table" operation.
     * @throws NullPointerException if the provided schema is null.
     */
    public CreateTableBuilder createTable(String table){
        Objects.requireNonNull(table, "table is required");
        return new CreateTableBuilder(table, this);
    }

    public Template template(String database){
        Objects.requireNonNull(database, "database is required");
        return new DefaultTemplate(database, this);
    }

    boolean executeTableCreation(CreateTable operation) {
        return execute(operation);
    }

    boolean execute(Operation operation){
        HttpRequest request = createRequest()
                .POST(ofByteArray(INSTANCE.writeValueAsBytes(operation)))
                .build();
        try {
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            return HttpStatus.OK.isEquals(response);
        } catch (IOException| InterruptedException e) {
            throw new HarperDBException("There is an issue to execute the operation: " + operation + "message: ", e);
        }
    }

    <T> Optional<T> singleResult(Operation operation, Class<T> type){
        List<T> entities = result(operation, type);
        if (entities.isEmpty()) {
            return Optional.empty();
        } else if (entities.size() == 1) {
            return Optional.of(entities.get(0));
        } else {
            throw new HarperDBException("There is more than one result in a single result: " + operation);
        }
    }

    <T> List<T> result(Operation operation, Class<T> type){
        HttpRequest request = createRequest()
                .POST(ofByteArray(INSTANCE.writeValueAsBytes(operation)))
                .build();
        try {
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            if(HttpStatus.OK.isEquals(response)){
                byte[] body = response.body();
                return INSTANCE.readValue(body, type);
            } else {
                return Collections.emptyList();
            }
        } catch (IOException| InterruptedException e) {
            throw new HarperDBException("There is an issue to execute the operation: " + operation + "message: ", e);
        }
    }


    HttpRequest.Builder createRequest() {
        return HttpRequest.newBuilder()
                .uri(host)
                .headers("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", auth.header());

    }



}
