package com.eneskoseoglu.foodorder.repository;

import com.eneskoseoglu.foodorder.enums.TableStatus;
import com.eneskoseoglu.foodorder.persistance.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantTableDao extends JpaRepository<RestaurantTable,Long> {
    List<RestaurantTable> findAllByStatus(TableStatus status);

    Optional<RestaurantTable> findByTableNumber(int number);

}
