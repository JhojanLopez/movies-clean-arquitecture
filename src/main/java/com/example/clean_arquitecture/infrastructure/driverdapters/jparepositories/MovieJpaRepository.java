package com.example.clean_arquitecture.infrastructure.driverdapters.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Integer>{
}
