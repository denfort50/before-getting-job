package ru.dkalchenko.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sells")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp sellDate;


    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private int amount;

    private int fullPrice;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sell sell = (Sell) o;
        return amount == sell.amount
                && fullPrice == sell.fullPrice
                && Objects.equals(sellDate, sell.sellDate)
                && Objects.equals(car, sell.car)
                && Objects.equals(person, sell.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellDate, car, amount, fullPrice, person);
    }
}
