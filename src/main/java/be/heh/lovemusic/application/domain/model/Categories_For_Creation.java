package be.heh.lovemusic.application.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categories_For_Creation {
    private String name;
    @JsonCreator
    public Categories_For_Creation(
            @JsonProperty("name") String name) {
        this.name = name;
    }
}
