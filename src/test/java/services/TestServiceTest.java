package services;

import org.example.entities.TestEntity;
import org.example.mappers.TestModelMapper;
import org.example.models.TestModel;
import org.example.repositories.TestRepository;
import org.example.services.TestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {

    @InjectMocks
    private TestService component;

    @Mock
    private TestRepository mockedTestRepository;

    @Mock
    private TestModelMapper mockedTestMapper;

    @Test
    public void getModels_should_call_repository() {
        component.getTestModels();
        verify(mockedTestRepository, times(1)).findAll();
    }

    @Test
    public void getModels_should_map_entities_to_models() {
        List<TestEntity> testEntities = getTestEntities();
        when(mockedTestRepository.findAll()).thenReturn(testEntities);
        component.getTestModels();
        verify(mockedTestMapper, times(1)).mapEntityToModel(testEntities.get(0));
        verify(mockedTestMapper, times(1)).mapEntityToModel(testEntities.get(1));
    }

    @Test
    public void getModels_should_return_mapped_models() {
        TestModel model = new TestModel();
        when(mockedTestRepository.findAll()).thenReturn(Collections.singletonList(buildTestEntity(1)));
        when(mockedTestMapper.mapEntityToModel(any())).thenReturn(model);
        assertEquals(model, component.getTestModels());
    }

    private static List<TestEntity> getTestEntities() {
        return Arrays.asList(buildTestEntity(1), buildTestEntity(2));
    }

    private static TestEntity buildTestEntity(int id) {
        TestEntity entity = new TestEntity();
        entity.setId(id);
        entity.setTestColumn("Column");
        entity.setTestDescription("Description");
        return entity;
    }

}