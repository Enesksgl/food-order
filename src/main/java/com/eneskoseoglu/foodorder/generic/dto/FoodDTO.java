package com.eneskoseoglu.foodorder.generic.dto;

import com.eneskoseoglu.foodorder.persistance.Food;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@SuperBuilder
public class FoodDTO {
    private String name;
    private String description;
    private Double price;
    private String photoUrl;

    public static FoodDTO of(@NotNull Food food ){
        return FoodDTO.builder().name(food.getName())
                .description(food.getDescription())
                .price(food.getPrice())
                .photoUrl(food.getPhotoUrl())
                .build();
    }
}
