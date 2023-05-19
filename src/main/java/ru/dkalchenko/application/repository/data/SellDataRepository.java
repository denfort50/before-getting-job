package ru.dkalchenko.application.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.dkalchenko.application.dto.SellDTO;
import ru.dkalchenko.application.model.Sell;

import java.sql.Timestamp;
import java.util.List;

public interface SellDataRepository extends CrudRepository<Sell, Integer> {

    @Query("select sum(s.fullPrice * s.amount) from Sell s where s.sellDate between :dateStart and :dateEnd")
    Integer getRevenue(@Param("dateStart") Timestamp dateStart, @Param("dateEnd") Timestamp dateEnd);

    @Query("""
              select new ru.dkalchenko.application.dto.SellDTO(p.lastName, p.firstName, p.phone, s.fullPrice * s.amount, s.sellDate, c.name, s.amount)
              from Sell s join fetch Car c on c.id = s.car.id join fetch Person p on p.id = s.person.id
              order by s.sellDate, p.lastName, p.firstName, s.fullPrice * s.amount""")
    List<SellDTO> getSellsInNecessaryOrder();
}
