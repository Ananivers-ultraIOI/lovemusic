package be.heh.lovemusic.application.port.in;

import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.domain.model.Categories_For_Creation;

import java.util.List;

public interface UseCase_In_Categories {
    public void add(Categories_For_Creation categories_for_creation);
    public void removeById(int id);
    public List<Categories> getAll();
    public List<Categories> getById(int id);
}
