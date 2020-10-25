package ru.refactoing.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.refactoing.model.PeopleModel;
import org.mockito.Mockito;
import ru.refactoing.repository.PeopleRepository;

class PeopleModelServiceTest {
    PeopleModel peopleModel;

    @Autowired
    PeopleService peopleService;

    @Before
    public void setUp() {
        peopleModel = new PeopleModel();
        peopleModel.setAge(18);
        peopleModel.setId(1L);
        peopleModel.setName("Name");
    }

    @Test
    void isPeopleExistTest() {
        PeopleRepository mockedRepo = Mockito.mock(PeopleRepository.class);
        Mockito.when(mockedRepo.findById(peopleModel.getId())).thenReturn(true);

        Assert.assertTrue(peopleService.comparePeopleWithDb(peopleModel));
    }

    @Test
    void updatePeopleDataTest() {
    }
}