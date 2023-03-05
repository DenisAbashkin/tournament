package com.friends.tournament.repository;

import com.friends.tournament.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

}
