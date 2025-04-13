package com.example.clean_arquitecture.infrastructure.entrypoints;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.clean_arquitecture.application.dtos.MovieRequestDTO;
import com.example.clean_arquitecture.application.usecases.MovieUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(MovieRestController.class)
class MovieRestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockitoBean   
    private MovieUseCase movieUseCase;
    @InjectMocks
    private MovieRestController movieRestController;

    @Test
    @DisplayName("Test save movie")
    void testSave() throws Exception {
        // given
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        MovieRequestDTO movieRequestDTO = MovieRequestDTO.builder()
                .title("Test Movie")
                .description("Test Description")
                .releaseDate(LocalDate.now())
                .duration(120)
                .build();
        // when
        when(movieUseCase.save(any(MovieRequestDTO.class))).thenReturn(movieRequestDTO);
        // then
        mockMvc.perform(post("/api/v1/movie").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(movieRequestDTO)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())    
                .andExpect(jsonPath("$.title").value("Test Movie"))
                .andExpect(jsonPath("$.description").value("Test Description"))
                .andExpect(jsonPath("$.releaseDate").value(movieRequestDTO.getReleaseDate().toString()))
                .andExpect(jsonPath("$.duration").value(120));
    }
}
