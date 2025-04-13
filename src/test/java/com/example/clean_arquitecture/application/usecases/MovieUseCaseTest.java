package com.example.clean_arquitecture.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.clean_arquitecture.application.dtos.MovieRequestDTO;
import com.example.clean_arquitecture.application.mappers.MovieDTOmapper;
import com.example.clean_arquitecture.domain.entities.Movie;
import com.example.clean_arquitecture.domain.gateways.MovieRepositoryGateway;

@ExtendWith(MockitoExtension.class) 
class MovieUseCaseTest {
    @Mock
    MovieRepositoryGateway movieRepositoryGateway;
    @Mock
    MovieDTOmapper mapperDtoMovie;
    @InjectMocks    
    private MovieUseCase movieUseCase;
    
    @Test
    @DisplayName("Test save movie")
    void testSave() { 
        //given
        MovieRequestDTO movieRequestDTO = MovieRequestDTO.builder()
        .title("Test Movie")
        .description("Test Description")
        .releaseDate(LocalDate.now())
        .duration(120)
        .build();   

        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        movie.setDescription("Test Description");
        movie.setReleaseDate(LocalDate.now());
        movie.setDuration(120);
        
        //when
        when(mapperDtoMovie.toDomain(any(MovieRequestDTO.class))).thenReturn(movie);
        movie.setId(1);
        when(movieRepositoryGateway.save(any(Movie.class))).thenReturn(movie);
        movieRequestDTO.setId(1);
        when(mapperDtoMovie.toDTO(any(Movie.class))).thenReturn(movieRequestDTO);

        //then
        MovieRequestDTO result = movieUseCase.save(movieRequestDTO);
        assertEquals(movieRequestDTO, result);
        
    }
}
