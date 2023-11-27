package expert.os.harperdb;

import java.net.URI;
import java.net.http.HttpClient;

public final class Server implements AutoCloseable {

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

    @Override
    public void close() throws Exception {
        this.client.close();

    }
}
