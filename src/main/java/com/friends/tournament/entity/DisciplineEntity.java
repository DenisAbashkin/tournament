package com.friends.tournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discipline")
public class DisciplineEntity {

    /**
     * Идентификатор исциплины
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Имя дисциплины
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
