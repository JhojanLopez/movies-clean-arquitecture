package com.example.clean_arquitecture.infrastructure.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.example.clean_arquitecture.domain.entities.Movie;
import com.example.clean_arquitecture.infrastructure.driverdapters.jparepositories.MovieEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapperMovie {
    private final ModelMapper mapper;
    
    public MovieEntity toEntityJpa(Movie movie) {
        return mapper.map(movie, MovieEntity.class);
    }

    public Movie toDomain(MovieEntity movieEntity) {    
        return mapper.map(movieEntity, Movie.class);
    }

}
