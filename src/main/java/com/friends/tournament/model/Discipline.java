package com.friends.tournament.model;

import com.friends.tournament.entity.DisciplineEntity;
import com.friends.tournament.entity.PlayerEntity;
import jakarta.persistence.*;

/**
 * Модель дисциплины
 */
@Entity
public class Discipline {

    /**
     * Идентификатор дисциплины
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Название дисциплины
     */
    private String name;

    /**
     * Метод преобразовывает сущность дисциплины в модель дисциплины
     *
     * @param entity сущность исциплины
     * @return модель дисциплины
     */
    public static Discipline toModel(DisciplineEntity entity) {
        Discipline model = new Discipline();
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

    public void setName(String username) {
        this.name = username;
    }
}
