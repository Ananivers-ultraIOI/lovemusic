package be.heh.lovemusic.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categories {
    private int id;
    private String name;
    public Categories(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
