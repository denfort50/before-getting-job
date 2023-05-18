package ru.dkalchenko.application.repository.jdbc;

import ru.dkalchenko.application.dto.SellDTO;

import java.sql.Timestamp;
import java.util.List;

public interface SellRepository {

    Integer getRevenue(Timestamp dateStart, Timestamp dateEnd);

    List<SellDTO> getSellsInNecessaryOrder();
}
