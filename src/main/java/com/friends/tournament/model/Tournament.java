package com.friends.tournament.model;

import jakarta.persistence.*;

/**
 * Модель игрока
 */
@Entity
public class Tournament {

    /**
     * Идентификатор игрока
     */
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private String name;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
