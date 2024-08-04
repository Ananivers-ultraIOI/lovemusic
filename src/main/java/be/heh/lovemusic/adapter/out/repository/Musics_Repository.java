package be.heh.lovemusic.adapter.out.repository;

import be.heh.lovemusic.application.domain.model.Musics;
import be.heh.lovemusic.application.domain.model.Musics_For_Creation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Musics_Repository {
    private final JdbcTemplate jdbcTemplate;
    public Musics_Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Musics> getAllMusicsRepository() {
        String sql = "SELECT * FROM musics";
        return jdbcTemplate.query(sql,new Musics_Row_Mapper());
    }
    public List<Musics> getMusicsByIdRepository(int id) {
        String sql = "SELECT musics.* FROM musics WHERE id = ?";
        return jdbcTemplate.query(sql,new Musics_Row_Mapper(),id);
    }
    public void addRepository(Musics_For_Creation musics_for_creation) {
        String sql = "INSERT INTO musics (title, artist, album, categoriesId) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,musics_for_creation.getTitle(),musics_for_creation.getArtist(),musics_for_creation.getAlbum(),musics_for_creation.getCategoriesId());
    }
    public void removeRepository(int id) {
        String sql = "DELETE FROM musics WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
    public boolean verifyRepository(String title, String artist, String album) {
        String sql = "SELECT * FROM musics WHERE artist = ? AND album = ? AND title = ?";
        if(jdbcTemplate.query(sql,new Musics_Row_Mapper(),artist,album,title)==null){
                return false;
        }
        return true;
    }
    public List<Musics> getMusicsByCategoriesIdRepository(int id) {
        String sql = "SELECT musics FROM musics WHERE categoriesId = ?";
        return jdbcTemplate.query(sql,new Musics_Row_Mapper(),id);
    }
    public boolean verifyByIdRepository(int id) {
        String sql = "SELECT * FROM musics WHERE id = ?";
        if(jdbcTemplate.query(sql,new Musics_Row_Mapper(),id)==null){
            return false;
        }
        return true;
    }
}
