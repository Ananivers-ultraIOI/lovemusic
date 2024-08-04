package be.heh.lovemusic.application.port.in;

import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;

import java.util.List;

public interface UseCase_In_Musics {
    public void add(Musics_For_Creation musics_for_creation);
    public void removeById(int id);
    public List<Musics> getAll();
    public List<Musics> getById(int id);
    public List<Musics> getByCategoryId(int id);
}
