package dev.diegopereira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.diegopereira.dsmovie.domain.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

}
