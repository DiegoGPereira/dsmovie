package dev.diegopereira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.diegopereira.dsmovie.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}
