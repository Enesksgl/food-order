package com.eneskoseoglu.foodorder.restapi;

import com.eneskoseoglu.foodorder.generic.dto.FoodDTO;
import com.eneskoseoglu.foodorder.models.FoodCreateUpdateModel;
import com.eneskoseoglu.foodorder.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodAPI {
    private final FoodService foodService;

    @PostMapping("/add")
    public FoodDTO addFood(@RequestBody FoodCreateUpdateModel model) {
        return FoodDTO.of(foodService.saveFood(model));
    }

    @GetMapping("/getAll")
    public List<FoodDTO> getAllFoods() {
        return foodService.getAllFood().stream().map((FoodDTO::of)).toList();
    }

}
