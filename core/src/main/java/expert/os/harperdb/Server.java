package expert.os.harperdb;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.Objects;

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

    }

}
