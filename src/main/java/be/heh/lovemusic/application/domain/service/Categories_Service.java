package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;
import be.heh.lovemusic.application.port.in.UseCase_In_Categories;
import be.heh.lovemusic.application.port.out.Categories_Out;

import java.util.List;

public class Categories_Service implements UseCase_In_Categories {
    Categories_Out categories_out;
    public Categories_Service(Categories_Out categories_out) {
        this.categories_out = categories_out;
    }
    @Override
    public void add(Categories_For_Creation categories_for_creation) {
        boolean isCategoryExist=categories_out.verifyCategories(categories_for_creation.getName());
        if(!isCategoryExist) {
            categories_out.addCategories(categories_for_creation);
        }
    }
    @Override
    public void removeById(int id) {
        boolean isCategoryExist=categories_out.verifyCategoriesById(id);
        if(isCategoryExist) {
            categories_out.removeCategories(id);
        }
    }
    @Override
    public List<Categories> getAll() {
        return categories_out.getAllCategories();
    }
    @Override
    public List<Categories> getById(int id) {
        boolean isCategoryExist=categories_out.verifyCategoriesById(id);
        if(isCategoryExist) {
            return categories_out.getCategoriesById(id);
        }else{
            return null;
        }
    }
}
