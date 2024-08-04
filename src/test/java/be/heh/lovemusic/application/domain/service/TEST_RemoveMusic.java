package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.port.out.Musics_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_RemoveMusic {
    private static final int ID_MUSIC = 1;
    private static final boolean CONDITION = true;
    @Test
    public void shouldRemoveMusic() {
        Musics_Out musics_out = mock(Musics_Out.class);
        Musics_Service musics_service = new Musics_Service(musics_out);
        when(musics_out.verifyId(ID_MUSIC)).thenReturn(CONDITION);
        musics_service.removeById(ID_MUSIC);
        verify(musics_out).removeMusics(ID_MUSIC);
    }
}
