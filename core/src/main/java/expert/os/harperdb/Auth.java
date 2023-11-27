package expert.os.harperdb;

import java.util.Base64;

record Auth(String username, String password, String header) {


    static Auth of(String username, String password) {
        String header = "Basic " + Base64.getEncoder()
                .encodeToString((username + ":" + password).getBytes());
        return new Auth(username, password, header);
    }

}
