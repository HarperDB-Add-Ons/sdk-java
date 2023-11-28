package expert.os.harperdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

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
    public boolean schema(String schema) {
        Objects.requireNonNull(schema, "schema is required");
        HttpRequest request = createRequest().POST(ofByteArray(INSTANCE.writeValueAsBytes(new CreateSchema(schema))))
                .build();

        try {
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return HttpStatus.OK.isEquals(response);
        } catch (IOException| InterruptedException e) {
            throw new HarperDBException("There is an issue to create the schema: " + schema, e);
        }
    }

    /**
     * Starts the process of building a "create table" operation for a specific schema.
     *
     * @param schema The name of the schema for the new table.
     * @return A CreateTableBuilder instance to further configure the "create table" operation.
     * @throws NullPointerException if the provided schema is null.
     */
    public CreateTableBuilder createTable(String schema){
        Objects.requireNonNull(schema, "schema is required");
        return new CreateTableBuilder(schema, this);
    }

    boolean executeTableCreation(CreateTable operation) {
        HttpRequest request = createRequest()
                .POST(ofByteArray(INSTANCE.writeValueAsBytes(operation)))
                .build();
        try {
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return HttpStatus.OK.isEquals(response);
        } catch (IOException| InterruptedException e) {
            throw new HarperDBException("There is an issue to create the table: " + operation, e);
        }
    }


    HttpRequest.Builder createRequest() {
        return HttpRequest.newBuilder()
                .uri(host)
                .headers("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", auth.header());

    }


}
