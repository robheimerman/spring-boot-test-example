package org.example.mappers;

import org.example.entities.TestEntity;
import org.example.models.TestModel;
import org.springframework.stereotype.Component;

@Component
public class TestModelMapper {
    public TestModel mapEntityToModel(TestEntity entity) {
        TestModel model = new TestModel();
        model.setId(entity.getId());
        model.setColumn(entity.getTestColumn());
        model.setDescription(entity.getTestDescription());
        return model;
    }
}
