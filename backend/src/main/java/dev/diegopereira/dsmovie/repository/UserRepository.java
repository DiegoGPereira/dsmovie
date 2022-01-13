package dev.diegopereira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.diegopereira.dsmovie.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
