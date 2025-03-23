package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrate;
}
