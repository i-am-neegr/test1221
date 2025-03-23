package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Meals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Meal> mealsList;

    private long date;

    public double getTotalCalories() {
        return mealsList.stream().mapToDouble(Meal::getCalories).sum();
    }
}
