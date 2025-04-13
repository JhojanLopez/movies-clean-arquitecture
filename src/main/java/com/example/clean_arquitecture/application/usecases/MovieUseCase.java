package com.example.clean_arquitecture.application.usecases;

import org.springframework.stereotype.Service;

import com.example.clean_arquitecture.application.dtos.MovieRequestDTO;
import com.example.clean_arquitecture.application.mappers.MovieDTOmapper;
import com.example.clean_arquitecture.domain.entities.Movie;
import com.example.clean_arquitecture.domain.gateways.MovieRepositoryGateway;

import lombok.RequiredArgsConstructor;

@Service //podria ser con otra anotacion como useCase (personalizada)
@RequiredArgsConstructor
public class MovieUseCase {
    private final MovieRepositoryGateway movieRepositoryGateway;
    private final MovieDTOmapper mapperDtoMovie;
    
    public MovieRequestDTO save(MovieRequestDTO movieRequestDTO){
        Movie movie = mapperDtoMovie.toDomain(movieRequestDTO);
        return mapperDtoMovie.toDTO(movieRepositoryGateway.save(movie));
    }

    public MovieRequestDTO findById(Integer id){
        return mapperDtoMovie.toDTO(movieRepositoryGateway.findById(id));
    }

    public void delete(Integer id){
        movieRepositoryGateway.delete(id);
    }
}
