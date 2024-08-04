package be.heh.lovemusic.adapter.out.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import be.heh.lovemusic.application.domain.model.Categories;
import org.springframework.jdbc.core.RowMapper;

public class Categories_Row_Mapper implements RowMapper<Categories> {
    @Override
    public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Categories(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}
