package be.heh.lovemusic.application.port.out;

import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;

import java.util.List;

public interface Musics_Out {
    public List<Musics> getAllMusics();
    public List<Musics> getMusicsById(int id);
    public boolean verifyMusics(String title, String artist, String album);
    public boolean verifyId(int id);
    public void addMusics(Musics_For_Creation musics_for_creation);
    public void removeMusics(int id);
    public List<Musics> getAllMusicsByCategory(int categoryId);
}
