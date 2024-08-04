package be.heh.lovemusic.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Musics {
    private int id;
    private String title;
    private String artist;
    private String album;
    private int categoriesId;
    public Musics(int id, String title, String artist, String album, int categoriesId) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.categoriesId = categoriesId;
    }
}
