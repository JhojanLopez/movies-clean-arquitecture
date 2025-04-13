package com.example.clean_arquitecture.infrastructure.entrypoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clean_arquitecture.application.dtos.MovieRequestDTO;
import com.example.clean_arquitecture.application.usecases.MovieUseCase;
import com.example.clean_arquitecture.domain.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieRestController {
    private final MovieUseCase movieUseCase;

    @PostMapping
    public ResponseEntity<MovieRequestDTO> save(@RequestBody MovieRequestDTO movieRequestDTO){
        return ResponseEntity.ok(movieUseCase.save(movieRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieRequestDTO> findById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(movieUseCase.findById(id));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        movieUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
