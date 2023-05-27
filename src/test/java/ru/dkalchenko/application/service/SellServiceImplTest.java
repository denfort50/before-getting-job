package ru.dkalchenko.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.dkalchenko.application.dto.SellDTO;
import ru.dkalchenko.application.repository.data.SellDataRepository;

@ContextConfiguration(classes = {SellServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SellServiceImplTest {

    @MockBean
    private SellDataRepository sellDataRepository;

    @Autowired
    private SellServiceImpl sellServiceImpl;

    @Test
    void testGetRevenue() {
        when(sellDataRepository.getRevenue(any(), any())).thenReturn(1);
        assertEquals(1, sellServiceImpl.getRevenue(mock(Timestamp.class), mock(Timestamp.class)).intValue());
        verify(sellDataRepository).getRevenue(any(), any());
    }

    @Test
    void testGetSellsInNecessaryOrder() {
        ArrayList<SellDTO> sellDTOList = new ArrayList<>();
        when(sellDataRepository.getSellsInNecessaryOrder()).thenReturn(sellDTOList);
        List<SellDTO> actualSellsInNecessaryOrder = sellServiceImpl.getSellsInNecessaryOrder();
        assertSame(sellDTOList, actualSellsInNecessaryOrder);
        assertTrue(actualSellsInNecessaryOrder.isEmpty());
        verify(sellDataRepository).getSellsInNecessaryOrder();
    }
}

