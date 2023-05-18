package ru.dkalchenko.application.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dkalchenko.application.dto.SellDTO;
import ru.dkalchenko.application.service.SellService;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/autoShop")
public class SellController {

    private final SellService sellService;

    @GetMapping("/revenue")
    public ResponseEntity<Map<String, Integer>> getRevenue(@RequestParam Map<String, String> params) {
        Integer result = sellService.getRevenue(
                Timestamp.valueOf(params.get("dateStart")),
                Timestamp.valueOf(params.get("dateEnd")));
        Map<String, Integer> response = new HashMap<>();
        response.put("revenue", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<List<SellDTO>> getAllInNecessaryOrder() {
        List<SellDTO> sellDTOList = sellService.getSellsInNecessaryOrder();
        return new ResponseEntity<>(sellDTOList, HttpStatus.OK);
    }
}
