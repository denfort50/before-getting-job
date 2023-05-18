package ru.dkalchenko.application.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.dkalchenko.application.model.Sell;

public interface SellDataRepository extends CrudRepository<Sell, Integer> {

}
