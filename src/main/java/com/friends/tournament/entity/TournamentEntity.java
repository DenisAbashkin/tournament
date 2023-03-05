package com.friends.tournament.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Сущность турнира
 */
@Entity
@Table(name = "tournament")
public class TournamentEntity {

    /**
     * Идентификатор игрока
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Лист игроков турнира
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id")
    private List<PlayerEntity> players;

    /**
     * Лист дисциплины турнира
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id")
    private List<DisciplineEntity> disciplines;
    /**
     * Название турнира
     */
    private String name;
    /**
     * Тип турнира
     */
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }

    public List<DisciplineEntity> getDisciplines() { return disciplines; }

    public void setDisciplines(List<DisciplineEntity> disciplines) { this.disciplines = disciplines; }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
