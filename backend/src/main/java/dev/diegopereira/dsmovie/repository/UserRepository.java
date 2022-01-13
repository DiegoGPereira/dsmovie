package dev.diegopereira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.diegopereira.dsmovie.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
