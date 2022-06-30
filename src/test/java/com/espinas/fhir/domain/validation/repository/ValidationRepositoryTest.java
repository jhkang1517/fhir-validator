package com.espinas.fhir.domain.validation.repository;

import com.espinas.fhir.domain.validation.collection.Validation;
import com.espinas.fhir.service.common.SequenceGeneratorService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidationRepositoryTest {

    @Autowired
    private ValidationRepository validationRepository;

    @BeforeAll
    public void setUp() {
        Validation validation = Validation.builder().data("{\"test title\":\"test contents\"}").build();
        validationRepository.save(validation);;
    }

    @Test
    @DisplayName("getValidation Test")
    public void getValidationTest() {
        List<Validation> validationList = validationRepository.findAll();
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getData());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getId());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getCreatedDate());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getLastModifiedDate());

        Assertions.assertAll(
                () -> assertEquals(validationList.size(), 1)
        );
    }
}