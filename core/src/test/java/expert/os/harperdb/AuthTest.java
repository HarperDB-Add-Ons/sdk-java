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