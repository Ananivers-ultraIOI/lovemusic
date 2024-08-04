package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.domain.model.Categories;
import be.heh.lovemusic.application.port.out.Categories_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class TEST_GetCategory_GetAllCategories {
    private static final int ID_CATEGORY = 1;
    private static final Categories CATEGORY1=new Categories(1,"Rock");
    private static final Categories CATEGORY2=new Categories(2,"Alternative");
    private static final ArrayList<Categories> CATEGORIES_LIST=new ArrayList<>();
    private static final boolean CONDITION = true;
    @Test
    public void shouldGetAllCategories() {
        CATEGORIES_LIST.add(CATEGORY1);
        CATEGORIES_LIST.add(CATEGORY2);
        Categories_Out categories_out = mock(Categories_Out.class);
        Categories_Service categories_service = new Categories_Service(categories_out);
        when(categories_out.getAllCategories()).thenReturn(CATEGORIES_LIST);
        Assertions.assertEquals(CATEGORIES_LIST,categories_service.getAll());
    }
    @Test
    public void shouldGetCategoryById() {
        CATEGORIES_LIST.add(CATEGORY1);
        Categories_Out categories_out = mock(Categories_Out.class);
        Categories_Service categories_service = new Categories_Service(categories_out);
        when(categories_out.verifyCategoriesById(CATEGORY1.getId())).thenReturn(CONDITION);
        when(categories_out.getCategoriesById(CATEGORY1.getId())).thenReturn(CATEGORIES_LIST);
        Assertions.assertEquals(CATEGORIES_LIST,categories_service.getById(ID_CATEGORY));
    }
}
