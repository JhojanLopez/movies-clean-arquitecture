package com.example.clean_arquitecture.infrastructure.driverdapters.jparepositories;

import org.springframework.stereotype.Repository;

import com.example.clean_arquitecture.domain.entities.Movie;
import com.example.clean_arquitecture.domain.exceptions.MovieNotFoundException;
import com.example.clean_arquitecture.domain.gateways.MovieRepositoryGateway;
import com.example.clean_arquitecture.infrastructure.mappers.MapperMovie;
import lombok.RequiredArgsConstructor;

@Repository//podria ser con otra anotacion como gateway (personalizada)
@RequiredArgsConstructor
public class MovieRepositoryGatewayImpl implements MovieRepositoryGateway {
    private final MovieJpaRepository movieJpaRepository;
    private final MapperMovie mapperMovie;

    @Override
    public Movie save(Movie movie) {
        MovieEntity movieEntity = mapperMovie.toEntityJpa(movie);
        movieJpaRepository.save(movieEntity);
        return mapperMovie.toDomain(movieEntity);
    }

    @Override
    public Movie findById(Integer id) {
        MovieEntity movieEntity = movieJpaRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        return mapperMovie.toDomain(movieEntity);
    }

    @Override
    public void delete(Integer id) {
        movieJpaRepository.deleteById(id);
    }

}
