package com.eneskoseoglu.foodorder.services;

import com.eneskoseoglu.foodorder.models.FoodCreateUpdateModel;
import com.eneskoseoglu.foodorder.persistance.Food;
import com.eneskoseoglu.foodorder.repository.FoodDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodDao foodDao;
    @Transactional
    public Food saveFood(FoodCreateUpdateModel model){
        return foodDao.save(Food.builder().name(model.getName()).description(model.getDescription()).price(model.getPrice()).photoUrl(model.getPhotoUrl()).build());
    }
    @Transactional
    public List<Food> getAllFood(){
        return foodDao.findAll();
    }

    @Transactional
    public Optional<Food> findById(Long id){
        return foodDao.findById(id);
    }

}
