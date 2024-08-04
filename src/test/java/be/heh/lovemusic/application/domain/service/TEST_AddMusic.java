package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;
import be.heh.lovemusic.application.port.out.Musics_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_AddMusic {
    private static final Musics_For_Creation MUSIC=new Musics_For_Creation("Rosanna","Toto","Toto IV",1);
    private static final boolean CONDITION = false;
    @Test
    public void shouldAddMusic(){
        Musics_Out musics_out=mock(Musics_Out.class);
        Musics_Service musics_service=new Musics_Service(musics_out);
        when(musics_out.verifyMusics(MUSIC.getTitle(),MUSIC.getArtist(),MUSIC.getAlbum())).thenReturn(CONDITION);
        musics_service.add(MUSIC);
        verify(musics_out).addMusics(MUSIC);
    }
}
