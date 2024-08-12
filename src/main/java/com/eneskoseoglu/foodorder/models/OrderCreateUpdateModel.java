package com.eneskoseoglu.foodorder.models;
import com.eneskoseoglu.foodorder.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class OrderCreateUpdateModel {
    private OrderStatus status;
    private List<Long> foodIds;
    private int tableNumber;
}
