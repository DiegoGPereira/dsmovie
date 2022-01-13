package dev.diegopereira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.diegopereira.dsmovie.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
