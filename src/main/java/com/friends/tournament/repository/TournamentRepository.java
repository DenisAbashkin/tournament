package com.friends.tournament.repository;

import com.friends.tournament.entity.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<TournamentEntity, Long> {
    TournamentEntity findByName(String username);
}
