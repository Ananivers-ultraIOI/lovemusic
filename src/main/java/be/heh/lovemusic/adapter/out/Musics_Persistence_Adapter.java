package be.heh.lovemusic.adapter.out;

import be.heh.lovemusic.adapter.out.repository.Categories_Repository;
import be.heh.lovemusic.adapter.out.repository.Musics_Repository;
import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;
import be.heh.lovemusic.application.port.out.Musics_Out;

import java.util.ArrayList;
import java.util.List;

public class Musics_Persistence_Adapter implements Musics_Out {
    private final Musics_Repository musics_repository;
    private final Categories_Repository categories_repository;
    public Musics_Persistence_Adapter(Musics_Repository musics_repository, Categories_Repository categories_repository) {
        this.musics_repository = musics_repository;
        this.categories_repository = categories_repository;
    }
    @Override
    public List<Musics> getAllMusics() {
        return musics_repository.getAllMusicsRepository();
    }

    @Override
    public List<Musics> getMusicsById(int id) {
        return musics_repository.getMusicsByIdRepository(id);
    }

    @Override
    public boolean verifyMusics(String title,String artist, String album) {
        return musics_repository.verifyRepository(title,artist,album);
    }

    @Override
    public boolean verifyId(int id) {
        return musics_repository.verifyByIdRepository(id);
    }

    @Override
    public void addMusics(Musics_For_Creation musics_for_creation) {
        musics_repository.addRepository(musics_for_creation);
    }

    @Override
    public void removeMusics(int id) {
        musics_repository.removeRepository(id);
    }

    @Override
    public List<Musics> getAllMusicsByCategory(int categoryId) {
        if (categories_repository.verifyByIdRepository(categoryId)){
            return musics_repository.getMusicsByCategoriesIdRepository(categoryId);
        }
        return null;
    }
}
