package controller;

import org.example.controller.AppController;
import org.example.models.TestModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.services.TestService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppControllerTest {

    @InjectMocks
    private AppController component;

    @Mock
    private TestService mockedTestService;

    @Test
    public void getModels_should_call_service() {
        component.getModels();
        verify(mockedTestService, times(1)).getTestModels();
    }

    @Test
    public void getModels_should_return_models_from_service() {
        List<TestModel> testModels = getTestModels();
        when(mockedTestService.getTestModels()).thenReturn(testModels);
        List<TestModel> models = component.getModels();
        assertEquals(testModels, models);
    }

    private static List<TestModel> getTestModels() {
        TestModel model = new TestModel();
        model.setId(1);
        model.setColumn("Column String");
        model.setDescription("Column Description");
        return Collections.singletonList(model);
    }
}