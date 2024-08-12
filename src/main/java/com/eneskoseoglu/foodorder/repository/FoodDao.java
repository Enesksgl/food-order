package com.eneskoseoglu.foodorder.repository;

import com.eneskoseoglu.foodorder.persistance.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDao  extends JpaRepository<Food, Long> {
}
