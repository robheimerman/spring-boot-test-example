package org.example.controller;

import org.example.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.services.TestService;

import java.util.List;

@RestController
@RequestMapping("test")
public class AppController {

    @Autowired
    private TestService testService;

    @GetMapping(produces = "application/json")
    public List<TestModel> getModels() {
        return testService.getTestModels();
    }
}
