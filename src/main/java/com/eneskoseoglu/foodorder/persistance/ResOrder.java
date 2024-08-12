package com.eneskoseoglu.foodorder.persistance;

import com.eneskoseoglu.foodorder.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
public class ResOrder extends Base {
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Date orderDate;
    @ManyToMany
    private List<Food> foods;

}
