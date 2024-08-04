package be.heh.lovemusic.application.port.out;

import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;

import java.util.List;

public interface Categories_Out {
    public List<Categories> getAllCategories();
    public List<Categories> getCategoriesById(int id);
    public boolean verifyCategories(String name);
    public boolean verifyCategoriesById(int id);
    public void addCategories(Categories_For_Creation categories_for_creation);
    public void removeCategories(int id);
}
