package com.example.clean_arquitecture.domain.gateways;

import com.example.clean_arquitecture.domain.entities.Movie;

/**
 * Podemos llamarla como nombreEntidadRepository o nombreEntidadRepositoryGateway
 * interfaz para el repositorio de peliculas
 * se define el contrato para el repositorio de peliculas
 * que es una clase que implementa esta interfaz
 * y que se encarga de guardar, buscar y eliminar peliculas
 * 
 * en clean architecture,
 * Las interfaces de los gateways deben definirse en la capa de dominio, 
 * específicamente en un paquete como domain.gateways o domain.ports.
 *  Estas interfaces declaran qué operaciones necesita el dominio sin especificar
 *  cómo se implementan.
Por ejemplo:
 */
public interface MovieRepositoryGateway {
    Movie save(Movie movie);
    Movie findById(Integer id);
    void delete(Integer id);
}
