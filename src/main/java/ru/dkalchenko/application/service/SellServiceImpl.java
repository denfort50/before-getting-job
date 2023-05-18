package ru.dkalchenko.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dkalchenko.application.dto.SellDTO;
import ru.dkalchenko.application.repository.jdbc.SellJdbcTemplate;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
public class SellServiceImpl implements SellService {

    private final SellJdbcTemplate sellRepository;

    public Integer getRevenue(Timestamp dateStart, Timestamp dateEnd) {
        return sellRepository.getRevenue(dateStart, dateEnd);
    }

    public List<SellDTO> getSellsInNecessaryOrder() {
        return sellRepository.getSellsInNecessaryOrder();
    }
}
