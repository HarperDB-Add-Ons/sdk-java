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
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

import static java.net.http.HttpRequest.BodyPublishers.ofByteArray;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String credentials = "root:password";
        String headerValue = "Basic " + Base64.getEncoder()
                .encodeToString(credentials.getBytes());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:9925"))
                .headers("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", headerValue)
                .POST(ofByteArray(JSONMapper.INSTANCE.writeValueAsBytes(new CreateSchema("test"))))
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);


    }
}
