package com.eneskoseoglu.foodorder.persistance;

import com.eneskoseoglu.foodorder.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableNumber;
    @OneToMany
    private List<ResOrder> orders;
    private String description;
    @Enumerated(EnumType.STRING)
    private TableStatus status;

}
