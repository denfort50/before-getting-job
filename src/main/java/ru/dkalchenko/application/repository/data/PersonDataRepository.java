package ru.dkalchenko.application.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.dkalchenko.application.model.Person;

public interface PersonDataRepository extends CrudRepository<Person, Integer> {
}
