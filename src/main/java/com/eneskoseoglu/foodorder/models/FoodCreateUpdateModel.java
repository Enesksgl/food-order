package com.eneskoseoglu.foodorder.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class FoodCreateUpdateModel {
    private String name;
    private String description;
    private Double price;
    private String photoUrl;
}
