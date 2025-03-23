package com.example.test.repository;

import com.example.test.model.Meals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealsRepository extends JpaRepository<Meals, Long> {

    List<Meals> findByUserIdAndDateBetween(Long userId, long startOfDay, long endOfDay);
    List<Meals> findByUserId(Long userId);
}
