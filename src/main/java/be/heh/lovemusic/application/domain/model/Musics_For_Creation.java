package be.heh.lovemusic.application.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Musics_For_Creation {
    private String title;
    private String artist;
    private String album;
    private int categoriesId;
    @JsonCreator
    public Musics_For_Creation(
            @JsonProperty("title") String title,
            @JsonProperty("artist") String artist,
            @JsonProperty("album") String album,
            @JsonProperty("categoriesId") int categoriesId) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.categoriesId = categoriesId;
    }
}
