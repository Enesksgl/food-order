package com.eneskoseoglu.foodorder.repository;

import com.eneskoseoglu.foodorder.enums.OrderStatus;
import com.eneskoseoglu.foodorder.persistance.ResOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResOrderDao extends JpaRepository<ResOrder,Long> {
    List<ResOrder> findAllByStatus(OrderStatus status);
}
