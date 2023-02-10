package com.friends.tournament.repository;

import com.friends.tournament.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findByName(String username);
}
