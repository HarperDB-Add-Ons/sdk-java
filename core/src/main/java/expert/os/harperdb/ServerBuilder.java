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
        Auth auth = new Auth(username, password);
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
