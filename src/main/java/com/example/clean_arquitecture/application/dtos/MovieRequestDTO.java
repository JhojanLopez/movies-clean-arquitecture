package com.example.clean_arquitecture.application.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class MovieRequestDTO {
    private Integer id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private int duration;
}
