package be.heh.lovemusic.adapter.out.persistance;

import be.heh.lovemusic.LovemusicApplication;
import be.heh.lovemusic.adapter.out.Categories_Persistence_Adapter;
import be.heh.lovemusic.adapter.out.repository.Categories_Repository;
import be.heh.lovemusic.application.domain.model.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LovemusicApplication.class)
public class TEST_Get_By_ID_Categories {
    @Autowired
    private Categories_Repository categories_repository;
    private Categories_Persistence_Adapter categories_persistence_adapter;
    @Test
    public void should_get_by_id() {
        categories_persistence_adapter = new Categories_Persistence_Adapter(categories_repository);
        List<Categories> categoriesList = categories_persistence_adapter.getAllCategories();
        categoriesList=categories_persistence_adapter.getCategoriesById(categoriesList.get(0).getId());
        Assertions.assertEquals("Rock", categoriesList.get(0).getName());
    }
}
