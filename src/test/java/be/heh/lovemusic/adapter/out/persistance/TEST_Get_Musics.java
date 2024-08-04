package be.heh.lovemusic.adapter.out.persistance;

import be.heh.lovemusic.LovemusicApplication;
import be.heh.lovemusic.adapter.out.Categories_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.Musics_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.repository.Categories_Repository;
import be.heh.lovemusic.adapter.out.repository.Musics_Repository;
import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Musics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LovemusicApplication.class)
public class TEST_Get_Musics {
    @Autowired
    private Musics_Repository musicsRepository;
    @Autowired
    private Categories_Repository categoriesRepository;
    private Musics_Persistence_Adapter musics_persistence_adapter;
    @Test
    public void testShouldGet(){
        musics_persistence_adapter=new Musics_Persistence_Adapter(musicsRepository, categoriesRepository);
        List<Musics> musicsList =musics_persistence_adapter.getAllMusics();
        Assertions.assertEquals(0,musicsList.size());
    }
}
