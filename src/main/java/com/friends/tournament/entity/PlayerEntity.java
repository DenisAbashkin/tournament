package com.friends.tournament.entity;

import jakarta.persistence.*;

/**
 * Сущность игрока
 */
@Entity
@Table(name = "player")
public class PlayerEntity {

    /**
     * Идентификатор игрока
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Имя игрока
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
