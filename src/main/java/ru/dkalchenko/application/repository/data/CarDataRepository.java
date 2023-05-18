package ru.dkalchenko.application.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.dkalchenko.application.model.Car;

public interface CarDataRepository extends CrudRepository<Car, Integer> {
}
