package be.heh.lovemusic.adapter.out.repository;

import be.heh.lovemusic.application.domain.model.Musics;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Musics_Row_Mapper implements RowMapper<Musics> {
    @Override
    public Musics mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Musics(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("artist"),
                rs.getString("album"),
                rs.getInt("categoriesId")
        );
    }
}
