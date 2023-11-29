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

import java.util.Base64;

record Auth(String username, String password, String header) {


    static Auth of(String username, String password) {
        String header = "Basic " + Base64.getEncoder()
                .encodeToString((username + ":" + password).getBytes());
        return new Auth(username, password, header);
    }

}
