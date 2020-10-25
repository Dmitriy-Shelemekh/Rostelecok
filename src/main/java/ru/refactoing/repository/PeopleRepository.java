package ru.refactoing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.refactoing.model.PeopleModel;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleModel, Long> {
}
