package expert.os.harperdb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerBuilderTest {
    @Test
    void shouldCreateServer() {
        Server server = ServerBuilder.of("http://localhost:9925")
                .withCredentials("testUser", "testPassword");

        assertNotNull(server);
    }

    @Test
    void shouldReturnErrorWhenThereIsNull() {
        // Arrange
        ServerBuilder serverBuilder = ServerBuilder.of("http://localhost:9925");

        // Act and Assert
        assertThrows(NullPointerException.class, () ->
                serverBuilder.withCredentials(null, "testPassword")
        );
    }

    @Test
    void shouldReturnErrorWhenThereIsNull2() {
        // Arrange
        ServerBuilder serverBuilder = ServerBuilder.of("http://localhost:9925");

        // Act and Assert
        assertThrows(NullPointerException.class, () ->
                serverBuilder.withCredentials("testUser", null)
        );
    }

    @Test
    void shouldReturnBuilderWithValidURL() {
        // Act
        ServerBuilder serverBuilder = ServerBuilder.of("http://localhost:9925");

        assertNotNull(serverBuilder);
    }

    @Test
    void shouldReturnNPEWhenThereIsNullURI() {
        assertThrows(NullPointerException.class, () ->
                ServerBuilder.of(null)
        );
    }

    @Test
    void shouldReturnErrorWhenURLIsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                ServerBuilder.of("http://example.com/path with spaces?query=invalid#fragment with spaces\n")
        );
    }
}