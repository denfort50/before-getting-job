package ru.dkalchenko.application.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import ru.dkalchenko.application.service.SellServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class SellControllerTest {

    private final SellServiceImpl sellService = Mockito.mock(SellServiceImpl.class);
    private final SellController sellController = new SellController(sellService);

    @Test
    void getRevenueThenSuccess() {
        Map<String, String> params = new HashMap<>(Map.of(
                "dateStart", "2021-10-01 00:00:00",
                "dateEnd", "2021-10-03 23:00:00"));
        assertThat(sellController.getRevenue(params).getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void getAllInNecessaryOrderThenSuccess() {
        assertThat(sellController.getAllInNecessaryOrder().getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}