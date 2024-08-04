package be.heh.lovemusic.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categories_For_Creation {
    private String name;
    public Categories_For_Creation(String name) {
        this.name = name;
    }
}
