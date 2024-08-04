package be.heh.lovemusic.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Musics_For_Creation {
    private String title;
    private String artist;
    private String album;
    private int categoriesId;
    public Musics_For_Creation(String title, String artist, String album, int categoriesId) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.categoriesId = categoriesId;
    }
}
