package com.example.test.service;

import com.example.test.model.Meal;
import com.example.test.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MealService {

    private final MealRepository mealRepository;

    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal getMealById(long id) {
        return mealRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Meal> getAllMealsByID(List<Long> ids) {
        return mealRepository.findAllById(ids);
    }
}
