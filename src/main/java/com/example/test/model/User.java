package com.example.test.model;

import com.example.test.enums.Aims;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "users")
@Entity
@Data
public class User {
    // В требованиях не был указан пол, а в формуле Харриса-Бенедикта он влиял. Поэтому расчет на мужчину
    // также будем учитывать что наш клиент ведет сидячий образ жизни

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "INT CHECK (age >= 11 AND age <= 155)")
    private int age;

    @Column(nullable = false, columnDefinition = "DECIMAL CHECK (weight >= 11 AND weight <= 444)")
    private double weight;

    @Column(nullable = false, columnDefinition = "DECIMAL CHECK (height >= 111 AND height <= 555)")
    private double height;

    @Enumerated(EnumType.STRING)
    private Aims aim;

    public int calculateCalories() {
        double calories = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age) * 1.2;
        switch (aim) {
            case LOSE -> calories -= 300;
            case GAIN -> calories += 300;
        }
        return (int) calories;
    }
}
