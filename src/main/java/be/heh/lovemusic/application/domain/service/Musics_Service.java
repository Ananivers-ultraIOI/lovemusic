package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;
import be.heh.lovemusic.application.port.in.UseCase_In_Musics;
import be.heh.lovemusic.application.port.out.Musics_Out;

import java.util.List;

public class Musics_Service implements UseCase_In_Musics {
    Musics_Out musics_out;
    public Musics_Service(Musics_Out musics_out) {
        this.musics_out = musics_out;
    }
    @Override
    public void add(Musics_For_Creation musics_for_creation) {
        boolean isMusicExist=musics_out.verifyMusics(musics_for_creation.getTitle(),musics_for_creation.getArtist(), musics_for_creation.getAlbum());
        if(!isMusicExist) {
            musics_out.addMusics(musics_for_creation);
        }
    }
    @Override
    public void removeById(int id) {
        boolean isMusicExist=musics_out.verifyId(id);
        if(isMusicExist) {
            musics_out.removeMusics(id);
        }
    }
    @Override
    public List<Musics> getAll() {
        return musics_out.getAllMusics();
    }
    @Override
    public List<Musics> getById(int id) {
        boolean isMusicExist=musics_out.verifyId(id);
        if(isMusicExist) {
            return musics_out.getMusicsById(id);
        }else{
            return null;
        }
    }
    @Override
    public List<Musics> getByCategoryId(int id) {
        return musics_out.getAllMusicsByCategory(id);
    }
}
