package com.eneskoseoglu.foodorder.restapi;
import com.eneskoseoglu.foodorder.enums.TableStatus;
import com.eneskoseoglu.foodorder.generic.dto.TableDTO;
import com.eneskoseoglu.foodorder.persistance.RestaurantTable;
import com.eneskoseoglu.foodorder.services.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/table")
@RequiredArgsConstructor
public class RestaurantTableAPI {
    private final RestaurantTableService restaurantTableService;

    @PostMapping("/add")
    public TableDTO addTable(@RequestBody RestaurantTable table) {
        return TableDTO.of(restaurantTableService.saveTable(table));
    }

    @GetMapping("/getAll")
    public List<TableDTO> getAllTable(@RequestParam(required = false) TableStatus status) {
        return status == null ?
                restaurantTableService.getAllTable().stream().map((TableDTO::of)).toList() :
                restaurantTableService.getAllTableByStatus(status).stream().map((TableDTO::of)).toList();
    }

}
