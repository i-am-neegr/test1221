package com.example.test.controller;

import com.example.test.dto.AddMealsDTO;
import com.example.test.model.Meals;
import com.example.test.service.MealsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals-per-day")
@RequiredArgsConstructor
public class MealsController {
    private final MealsService mealsService;

    @PostMapping()
    public ResponseEntity<Meals> addMeal(@RequestBody AddMealsDTO meal) {
        return ResponseEntity.ok(mealsService.addMeal(meal));
    }

    @GetMapping("/daily-colories")
    public ResponseEntity<Double> getTotalCaloriesForDay(@RequestParam long userId,
                                                         @RequestParam long timestamp) {
        return ResponseEntity.ok(mealsService.getTotalCaloriesForDay(userId, timestamp));
    }

    @GetMapping("/calorie-check")
    public ResponseEntity<Boolean> isWithinCalorieLimit(@RequestParam long userId,
                                                        @RequestParam long timestamp) {
        return ResponseEntity.ok(mealsService.isWithinCalorieLimit(userId, timestamp));
    }

    @GetMapping("/meal-history")
    public ResponseEntity<List<Meals>> getMealHistory(@RequestParam long userId) {
        return ResponseEntity.ok(mealsService.getMealHistory(userId));
    }
}