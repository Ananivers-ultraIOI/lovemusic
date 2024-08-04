package be.heh.lovemusic.application.domain.service;

import be.heh.lovemusic.application.domain.model.Categories_For_Creation;
import be.heh.lovemusic.application.port.out.Categories_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_AddCategory {
    private static final Categories_For_Creation CATEGORY=new Categories_For_Creation("Rock");
    private static final boolean CONDITION=false;
    @Test
    public void shouldAddCategory() {
        Categories_Out categories_out = mock(Categories_Out.class);
        Categories_Service categories_service = new Categories_Service(categories_out);
        when(categories_out.verifyCategories(CATEGORY.getName())).thenReturn(CONDITION);
        categories_service.add(CATEGORY);
        verify(categories_out).addCategories(CATEGORY);
    }
}
