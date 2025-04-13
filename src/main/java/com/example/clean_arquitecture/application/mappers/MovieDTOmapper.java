package com.example.clean_arquitecture.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.clean_arquitecture.application.dtos.MovieRequestDTO;
import com.example.clean_arquitecture.domain.entities.Movie;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MovieDTOmapper {
    private final ModelMapper modelMapper;

    public Movie toDomain(MovieRequestDTO movieRequestDTO) {
        return modelMapper.map(movieRequestDTO, Movie.class);
    }

    public MovieRequestDTO toDTO(Movie movie) {
        return modelMapper.map(movie, MovieRequestDTO.class);
    }

}
