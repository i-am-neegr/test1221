package com.example.test.controller;

import com.example.test.model.Meal;
import com.example.test.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @PostMapping()
    public ResponseEntity<Meal> addDish(@RequestBody Meal dish) {
        return ResponseEntity.ok(mealService.addMeal(dish));
    }

}
