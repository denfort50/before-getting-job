package ru.dkalchenko.application.repository.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dkalchenko.application.dto.SellDTO;

import java.sql.Timestamp;
import java.util.List;

@Repository
@AllArgsConstructor
public class SellJdbcTemplate implements SellRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_REVENUE = """
            select sum(s.full_price * s.amount) as revenue
            from sells s
            where s.sell_date between ? and ?""";
    private static final String GET_DATA = """
            select p.last_name, p.first_name, p.phone, s.full_price * s.amount as order_price, s.sell_date as order_date, c.name as auto_name, s.amount
            from sells s join cars c on c.id = s.car_id join persons p on p.id = s.person_id
            order by s.sell_date, p.last_name, p.first_name, s.full_price * s.amount""";

    private final RowMapper<SellDTO> sellDTORowMapper = (resultSet, rowNum) -> {
        SellDTO sellDTO = new SellDTO();
        sellDTO.setLastName(resultSet.getString("last_name"));
        sellDTO.setFirstName(resultSet.getString("first_name"));
        sellDTO.setPhone(resultSet.getString("phone"));
        sellDTO.setOrderPrice(resultSet.getInt("order_price"));
        sellDTO.setOrderDate(resultSet.getTimestamp("order_date"));
        sellDTO.setAutoName(resultSet.getString("auto_name"));
        sellDTO.setAmount(resultSet.getInt("amount"));
        return sellDTO;
    };

    public Integer getRevenue(Timestamp dateStart, Timestamp dateEnd) {
        List<Integer> integerList = jdbcTemplate.query(GET_REVENUE,
                (rs, rowNum) -> rs.getInt(1), dateStart, dateEnd);
        return integerList.get(0);
    }

    public List<SellDTO> getSellsInNecessaryOrder() {
        return jdbcTemplate.query(GET_DATA, sellDTORowMapper);
    }
}
