package com.eneskoseoglu.foodorder.services;

import com.eneskoseoglu.foodorder.enums.OrderStatus;
import com.eneskoseoglu.foodorder.enums.TableStatus;
import com.eneskoseoglu.foodorder.models.OrderCreateUpdateModel;
import com.eneskoseoglu.foodorder.persistance.ResOrder;
import com.eneskoseoglu.foodorder.repository.ResOrderDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ResOrderDao resOrderDao;
    private final FoodService foodService;
    private final RestaurantTableService restaurantTableService;

    @Transactional
    public ResOrder saveOrder(OrderCreateUpdateModel model) {
        var resOrder = ResOrder.builder()
                .orderDate(new Date())
                .foods(model.getFoodIds().stream().map(id -> foodService.findById(id).orElseThrow(() -> new IllegalArgumentException("Yemek mevcut Değil"))).toList())
                .status(OrderStatus.NEW)
                .build();
        var table = restaurantTableService.findByTableNumber(model.getTableNumber()).orElseThrow();
        if (List.of(TableStatus.IDLE, TableStatus.USING).contains(table.getStatus())) {
            var orders = table.getOrders();
            orders.add(resOrder);
            table.setOrders(orders);
            table.setStatus(TableStatus.USING);
        } else {
            throw new IllegalStateException("Masa Reserve Edilmiş.");
        }

        return resOrderDao.save(resOrder);
    }
    @Transactional
    public List<ResOrder> getAllOrders(){
        return resOrderDao.findAll();
    }

    @Transactional
    public List<ResOrder> getAllOrdersByStatus(OrderStatus status) {
        return resOrderDao.findAllByStatus(status);
    }
}
