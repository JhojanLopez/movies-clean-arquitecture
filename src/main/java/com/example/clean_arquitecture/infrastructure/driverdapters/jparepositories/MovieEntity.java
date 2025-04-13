package com.example.clean_arquitecture.infrastructure.driverdapters.jparepositories;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;    


/**
 * Entidad mapeada por JPA      
 * para la tabla movies
 * 
 * Se encuentra en la capa de infrastructure    
 * ya que es una clase que se encarga de mapear la entidad Movie
 * a la tabla movies en la base de datos usando el framework Spring Data JPA
 * 
 */
@Entity
@Table(name = "movies") 
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private int duration;
}
