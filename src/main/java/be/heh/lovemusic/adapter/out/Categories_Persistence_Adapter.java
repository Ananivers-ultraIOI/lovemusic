package be.heh.lovemusic.adapter.out;

import be.heh.lovemusic.adapter.out.repository.Categories_Repository;
import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;
import be.heh.lovemusic.application.port.out.Categories_Out;

import java.util.List;

public class Categories_Persistence_Adapter implements Categories_Out {
    private final Categories_Repository categories_repository;
    public Categories_Persistence_Adapter(Categories_Repository categories_repository) {
        this.categories_repository = categories_repository;
    }
    @Override
    public List<Categories> getAllCategories() {
        return categories_repository.getAllCategoriesRepository();
    }
    @Override
    public List<Categories> getCategoriesById(int id) {
        return categories_repository.getCategoriesByIdRepository(id);
    }
    @Override
    public boolean verifyCategories(String name){
        return categories_repository.verifyRepository(name);
    }

    @Override
    public boolean verifyCategoriesById(int id) {
        return categories_repository.verifyByIdRepository(id);
    }

    @Override
    public void addCategories(Categories_For_Creation categories_for_creation) {
        categories_repository.addRepository(categories_for_creation);
    }
    public void removeCategories(int id) {
        categories_repository.removeRepository(id);
    }
}
