package com.friends.tournament.model;

import com.friends.tournament.entity.PlayerEntity;

/**
 * Модель игрока
 */
public class Player {

    /**
     * Идентификатор игрока
     */
    private Long id;
    /**
     * Имя игрока в турнире
     */
    private String name;

    /**
     * Метод преобразовывает сущность игрока в модель игрока
     *
     * @param entity сущность игрока
     * @return модель игрока
     */
    public static Player toModel(PlayerEntity entity) {
        Player model = new Player();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

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
