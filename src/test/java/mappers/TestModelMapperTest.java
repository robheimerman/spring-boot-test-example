package mappers;

import org.example.entities.TestEntity;
import org.example.mappers.TestModelMapper;
import org.example.models.TestModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TestModelMapperTest {

    @InjectMocks
    private TestModelMapper component;

    @Test
    public void mapEntityToModel_should_set_the_fields() {
        TestModel testModel = component.mapEntityToModel(buildTestEntity());
        assertEquals(1, testModel.getId());
        assertEquals("Column", testModel.getColumn());
        assertEquals("Description", testModel.getDescription());
    }

    private static TestEntity buildTestEntity() {
        TestEntity entity = new TestEntity();
        entity.setId(1);
        entity.setTestColumn("Column");
        entity.setTestDescription("Description");
        return entity;
    }
}