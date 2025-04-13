package com.example.clean_arquitecture.domain.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * clase entidad para representar una pelicula
 * con sus atributos y metodos
 * aunque se use lombok, esto no rompe con la arquitectura clean
 * ya que se agrega codigo que no es directamente del framework
 * sino que es codigo del lenguaje java
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Integer id;
    private String title;
    private String description;
    private int duration;
    private LocalDate releaseDate;
}
