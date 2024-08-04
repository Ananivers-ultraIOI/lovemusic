package be.heh.lovemusic.adapter.out.repository;

import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Categories_Repository {
    private final JdbcTemplate jdbcTemplate;
    public Categories_Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Categories> getAllCategoriesRepository() {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql,new Categories_Row_Mapper());
    }
    public List<Categories> getCategoriesByIdRepository(int id) {
        String sql = "SELECT categories.* FROM categories WHERE categories.id = ?";
        return jdbcTemplate.query(sql,new Categories_Row_Mapper(),id);
    }
    public void addRepository(Categories_For_Creation categories_for_creation) {
        String sql = "INSERT INTO categories (name) VALUES (?)";
        jdbcTemplate.update(sql,categories_for_creation.getName());
    }
    public void removeRepository(int id) {
        String sql = "DELETE FROM categories WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
    public boolean verifyRepository(String name) {
        String sql = "SELECT * FROM categories WHERE name = ?";
        List<Categories> categoriesList=jdbcTemplate.query(sql,new Categories_Row_Mapper(),name);
        if(categoriesList.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean verifyByIdRepository(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        List<Categories> categoriesList=jdbcTemplate.query(sql,new Categories_Row_Mapper(),id);
        if(categoriesList.isEmpty()){
            return false;
        }
        return true;
    }
}
