package com.eneskoseoglu.foodorder.generic.dto;

import com.eneskoseoglu.foodorder.enums.TableStatus;
import com.eneskoseoglu.foodorder.persistance.RestaurantTable;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@SuperBuilder
public class TableDTO {
    private int tableNumber;
    private ResOrderDTO[] orders;
    private TableStatus status;
    private String description;

    public static TableDTO of(@NotNull RestaurantTable table) {
        return TableDTO.builder().tableNumber(table.getTableNumber())
                .description(table.getDescription())
                .orders(table.getOrders().stream().map(ResOrderDTO::of).toArray(ResOrderDTO[]::new))
                .status(table.getStatus())
                .build();
    }
}
