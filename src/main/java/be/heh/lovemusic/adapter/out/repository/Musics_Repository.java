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
        String sql = "SELECT musics.* FROM musics WHERE musics.id = ?";
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
        List<Musics> musicsList = jdbcTemplate.query(sql,new Musics_Row_Mapper(),artist,title,album);
        if(musicsList.isEmpty()){
                return false;
        }
        return true;
    }
    public List<Musics> getMusicsByCategoriesIdRepository(int categoriesId) {
        String sql = "SELECT * FROM musics WHERE musics.categoriesid = ?";
        return jdbcTemplate.query(sql,new Musics_Row_Mapper(),categoriesId);
    }
    public boolean verifyByIdRepository(int id) {
        String sql = "SELECT * FROM musics WHERE id = ?";
        List<Musics> musicsList  = jdbcTemplate.query(sql,new Musics_Row_Mapper(),id);
        if(musicsList.isEmpty()){
            return false;
        }
        return true;
    }
}
