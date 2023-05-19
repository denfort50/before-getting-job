package ru.dkalchenko.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO {

    private String lastName;

    private String firstName;

    private String phone;

    private int orderPrice;

    private Date orderDate;

    private String autoName;

    private int amount;
}
