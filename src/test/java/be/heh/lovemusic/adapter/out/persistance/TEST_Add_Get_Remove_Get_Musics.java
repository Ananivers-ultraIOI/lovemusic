package be.heh.lovemusic.adapter.out.persistance;

import be.heh.lovemusic.LovemusicApplication;
import be.heh.lovemusic.adapter.out.Categories_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.Musics_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.repository.Categories_Repository;
import be.heh.lovemusic.adapter.out.repository.Musics_Repository;
import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;
import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LovemusicApplication.class)
public class TEST_Add_Get_Remove_Get_Musics {
    @Autowired
    private Musics_Repository musics_repository;
    @Autowired
    private Categories_Repository categories_repository;
    private Musics_Persistence_Adapter musics_persistence_adapter;
    private static final Musics_For_Creation MUSICB = new Musics_For_Creation("Africa","Toto","Toto IV",1);
    @Test
    public void shouldAddGetAndRemove() {
        musics_persistence_adapter= new Musics_Persistence_Adapter(musics_repository,categories_repository);
        musics_persistence_adapter.addMusics(MUSICB);
        List<Musics> musicsList = musics_persistence_adapter.getAllMusics();
        Assertions.assertEquals(2, musicsList.size());
        musics_persistence_adapter.removeMusics(musicsList.get(1).getId());
        musicsList = musics_persistence_adapter.getAllMusics();
        Assertions.assertEquals(1, musicsList.size());
    }
}
