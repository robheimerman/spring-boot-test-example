package org.example.services;

import org.example.entities.TestEntity;
import org.example.mappers.TestModelMapper;
import org.example.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repositories.TestRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestModelMapper testModelMapper;


    public List<TestModel> getTestModels() {
        List<TestEntity> entities = testRepository.findAll();

        return entities
                .stream()
                .map(entity -> testModelMapper.mapEntityToModel(entity))
                .collect(Collectors.toList());
    }
}
