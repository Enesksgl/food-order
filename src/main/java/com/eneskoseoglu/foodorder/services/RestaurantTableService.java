package com.eneskoseoglu.foodorder.services;

import com.eneskoseoglu.foodorder.enums.TableStatus;
import com.eneskoseoglu.foodorder.persistance.RestaurantTable;
import com.eneskoseoglu.foodorder.repository.RestaurantTableDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {
    private final RestaurantTableDao restaurantTableDao;

    @Transactional
    public RestaurantTable saveTable(RestaurantTable table) {
        return restaurantTableDao.save(table);
    }

    @Transactional
    public Optional<RestaurantTable> findByTableNumber(int number){
        return  restaurantTableDao.findByTableNumber(number);
    }

    @Transactional
    public List<RestaurantTable> getAllTable() {
        return restaurantTableDao.findAll();
    }

    @Transactional
    public List<RestaurantTable> getAllTableByStatus(TableStatus status) {
        return restaurantTableDao.findAllByStatus(status);
    }
}
