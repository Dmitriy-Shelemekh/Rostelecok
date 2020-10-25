package ru.refactoing.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.refactoing.model.PeopleModel;
import ru.refactoing.repository.PeopleRepository;

import java.util.Optional;

@Service
@Slf4j
public class PeopleService {

    private PeopleRepository repository;

    @Autowired
    public void setRepository(PeopleRepository repository) {
        this.repository = repository;
    }

    /**
     * метод должен возвращать любого вида ответ, по которому можно понять, равны ли все поля
     * переданного параметра с полями найденной в БД сущности
     */
    public boolean comparePeopleWithDb(PeopleModel peopleModel) {
        Optional<PeopleModel> peopleFromDb = repository.findById(peopleModel.getId());

        if (!peopleFromDb.isPresent()) {
            log.error("No people found in DB. People ID: " + peopleModel.getId());
            throw new IllegalArgumentException();
        }

        return peopleModel.equals(peopleFromDb.get());
    }

    /**
     * метод должен обновить в БД поля aField и bField по переданному идентификатору
     * возвращать ответ в любом виде, по которому можно понять, изменились ли данные в БД
     */
    public boolean updatePeopleData(PeopleModel peopleModel) {
        if (!comparePeopleWithDb(peopleModel)) {
            repository.save(peopleModel);
            log.info("People was updated! People: " + peopleModel);

            return true;
        }

        return false;
    }
}