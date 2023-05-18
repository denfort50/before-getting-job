package ru.dkalchenko.application.service;

import ru.dkalchenko.application.dto.SellDTO;

import java.sql.Timestamp;
import java.util.List;

public interface SellService {

    Integer getRevenue(Timestamp dateStart, Timestamp dateEnd);

    List<SellDTO> getSellsInNecessaryOrder();
}
