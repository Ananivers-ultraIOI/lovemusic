package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.port.out.Categories_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_RemoveCategory {
    private static final int ID_CATEGORY = 1;
    private static final boolean CONDITION = true;
    @Test
    public void shouldRemoveCategory() {
        Categories_Out categories_out = mock(Categories_Out.class);
        Categories_Service categories_service = new Categories_Service(categories_out);
        when(categories_out.verifyCategoriesById(ID_CATEGORY)).thenReturn(CONDITION);
        categories_service.removeById(ID_CATEGORY);
        verify(categories_out).removeCategories(ID_CATEGORY);
    }
}
