package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.port.out.Musics_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TEST_GetMusic_GetAllMusics {
    private static final int ID_MUSIC = 2;
    private static final int ID_CATEGORY = 2;
    private static final Musics MUSIC1=new Musics(1,"Rosanna","Toto","Toto IV",1);
    private static final Musics MUSIC2=new Musics(2,"Blue","Peter McPoland","Piggy",2);
    private static final Musics MUSIC3=new Musics(3,"I Want You","Peter McPoland","Piggy",2);
    private static final ArrayList<Musics> MUSICS_LIST=new ArrayList<>();
    private static final boolean CONDITION = true;
    @Test
    public void shouldGetAllMusics() {
        MUSICS_LIST.add(MUSIC1);
        MUSICS_LIST.add(MUSIC2);
        Musics_Out musics_out = mock(Musics_Out.class);
        Musics_Service musics_service = new Musics_Service(musics_out);
        when(musics_out.getAllMusics()).thenReturn(MUSICS_LIST);
        Assertions.assertEquals(MUSICS_LIST,musics_service.getAll());
    }
    @Test
    public void shouldGetMusicById() {
        MUSICS_LIST.add(MUSIC2);
        Musics_Out musics_out = mock(Musics_Out.class);
        Musics_Service musics_service = new Musics_Service(musics_out);
        when(musics_out.verifyId(ID_MUSIC)).thenReturn(CONDITION);
        when(musics_out.getMusicsById(ID_MUSIC)).thenReturn(MUSICS_LIST);
        Assertions.assertEquals(MUSICS_LIST,musics_service.getById(ID_CATEGORY));
    }
    @Test
    public void shouldGetMusicByCategoryId() {
        MUSICS_LIST.add(MUSIC2);
        MUSICS_LIST.add(MUSIC3);
        Musics_Out musics_out = mock(Musics_Out.class);
        Musics_Service musics_service = new Musics_Service(musics_out);
        when(musics_out.getAllMusicsByCategory(ID_CATEGORY)).thenReturn(MUSICS_LIST);
        Assertions.assertEquals(MUSICS_LIST,musics_service.getByCategoryId(ID_CATEGORY));
    }
}
