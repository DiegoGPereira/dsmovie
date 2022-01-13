package dev.diegopereira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.diegopereira.dsmovie.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
