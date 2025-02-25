package com.nba.spring_basketball;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {
    void deleteByName(String playerName);

    Optional<Player> findByName(String name);

}