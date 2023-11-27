package expert.os.harperdb;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


class AuthTest {

    @Test
    void shouldCreateInstanceFromStaticMethod() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        // Act
        Auth auth = Auth.of(username, password);
        String expectedHeader = "Basic " + java.util.Base64.getEncoder()
                .encodeToString((username + ":" + password).getBytes());

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(auth.username()).isEqualTo(username);
            softly.assertThat(auth.password()).isEqualTo(password);
            softly.assertThat(auth.header()).isEqualTo(expectedHeader);
        });


    }
}