package com.example.clean_arquitecture.infrastructure.driverdapters.jparepositories;

import com.example.clean_arquitecture.domain.entities.Movie;
import com.example.clean_arquitecture.domain.exceptions.MovieNotFoundException;
import com.example.clean_arquitecture.infrastructure.mappers.MapperMovie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;    
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) 
class MovieRepositoryGatewayImplTest {

    @Mock
    private MovieJpaRepository movieJpaRepository;

    @Mock
    private MapperMovie mapperMovie;

    @InjectMocks
    private MovieRepositoryGatewayImpl movieRepositoryGateway;

    @Test
    @DisplayName("Test save movie")
    void testSave() {
        //given
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Test Movie");
        movie.setDescription("Test Description");
        movie.setReleaseDate(LocalDate.now());
        movie.setDuration(120);

        MovieEntity movieEntity = MovieEntity.builder()
        .title("Test Movie")
        .description("Test Description")
        .releaseDate(LocalDate.now())
        .duration(120)
        .build();

        //when
        when(mapperMovie.toEntityJpa(any(Movie.class))).thenReturn(movieEntity);
        when(movieJpaRepository.save(any(MovieEntity.class))).thenReturn(movieEntity);
        movie.setId(1);
        when(mapperMovie.toDomain(movieEntity)).thenReturn(movie);
        //then
        Movie result = movieRepositoryGateway.save(movie);
        assertEquals(movie, result);
        
    }

    
    @Test
    @DisplayName("Find movie by id -> exception not found")
    void findByIdNotFound() { 
        //when
        when(movieJpaRepository.findById(any(Integer.class))).thenReturn(Optional.empty());
        //then
        assertThrows(MovieNotFoundException.class, () -> movieRepositoryGateway.findById(1));
    }

    @Test
    @DisplayName("Find movie by id -> success")
    void findById() { 
        //given
        Movie movie = new Movie();  
        movie.setId(1);
        movie.setTitle("Test Movie");
        movie.setDescription("Test Description");
        movie.setReleaseDate(LocalDate.now());
        movie.setDuration(120);

        MovieEntity movieEntity = MovieEntity.builder()
        .id(1)
        .title("Test Movie")
        .description("Test Description")
        .releaseDate(LocalDate.now())
        .duration(120)
        .build();

        //when
        when(movieJpaRepository.findById(any(Integer.class))).thenReturn(Optional.of(movieEntity));
        when(mapperMovie.toDomain(movieEntity)).thenReturn(movie);
        //then
        Movie result = movieRepositoryGateway.findById(1);
        assertEquals(movie, result);    
    }

    @Test
    @DisplayName("Delete movie")
    void delete() { 
        //when
        movieRepositoryGateway.delete(1);
        //then
        verify(movieJpaRepository, times(1)).deleteById(1);
    }
} 