package com.eneskoseoglu.foodorder.generic.dto;

import com.eneskoseoglu.foodorder.enums.OrderStatus;
import com.eneskoseoglu.foodorder.persistance.Food;
import com.eneskoseoglu.foodorder.persistance.ResOrder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
@SuperBuilder
public class ResOrderDTO {

    private OrderStatus status;
    private Date orderDate;
    private FoodDTO[] foods;
    private Double totalPrice;

    public static ResOrderDTO of(@NotNull ResOrder order) {
        return ResOrderDTO.builder()
                .orderDate(order.getOrderDate())
                .foods(order.getFoods().stream().map(FoodDTO::of).toArray(FoodDTO[]::new))
                .totalPrice(order.getFoods().stream().mapToDouble(Food::getPrice).sum())
                .status(order.getStatus())
                .build();
    }
}
