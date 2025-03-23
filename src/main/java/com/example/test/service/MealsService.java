package com.example.test.service;

import com.example.test.dto.AddMealsDTO;
import com.example.test.model.Meal;
import com.example.test.model.Meals;
import com.example.test.model.User;
import com.example.test.repository.MealsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealsService {
    private final MealsRepository mealsRepository;
    private final UserService userService;
    private final MealService mealService;

    public Meals addMeal(AddMealsDTO mealsDTO) {
        User user = userService.findUserById(mealsDTO.getUserId());
        List<Meal> meals = mealService.getAllMealsByID(mealsDTO.getMealsIds());
        Meals meals1 = new Meals();
        meals1.setMealsList(meals);
        meals1.setUser(user);
        meals1.setDate(System.currentTimeMillis());

        return mealsRepository.save(meals1);
    }

    private long getStartOfDay(long timestamp) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
                .atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    private long getEndOfDay(long timestamp) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
                .plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli() - 1;
    }

    public double getTotalCaloriesForDay(Long userId, long timestamp) {
        long startOfDay = getStartOfDay(timestamp);
        long endOfDay = getEndOfDay(timestamp);

        List<Meals> meals = mealsRepository.findByUserIdAndDateBetween(userId, startOfDay, endOfDay);
        return meals.stream().mapToDouble(Meals::getTotalCalories).sum();
    }

    public boolean isWithinCalorieLimit(Long userId, long timestamp) {
        double caloriesForDay = getTotalCaloriesForDay(userId, timestamp);
        User user = userService.findUserById(userId);

        return  caloriesForDay <= user.calculateCalories();
    }

    public List<Meals> getMealHistory(Long userId) {
        return mealsRepository.findByUserId(userId);
    }
}
