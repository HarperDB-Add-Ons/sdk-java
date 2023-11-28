package expert.os.harperdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Animal(@JsonProperty String id, @JsonProperty String name) {

}
