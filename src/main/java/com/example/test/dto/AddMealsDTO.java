package com.example.test.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class AddMealsDTO {
    long userId;
    @Column(insertable=false, updatable=false, nullable=false)
    List<Long> mealsIds;
}
