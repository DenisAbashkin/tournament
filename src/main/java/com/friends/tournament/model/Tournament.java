package com.friends.tournament.model;

import com.friends.tournament.entity.TournamentEntity;

import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

/**
 * Модель игрока
 */
public class Tournament {

    /**
     * Идентификатор игрока
     */
    private Long id;

    /**
     * Лист игроков турнира
     */
    private List<Player> players;

    /**
     * Лист игроков турнира
     */
    private  List<Discipline> disciplines;

    /**
     * Название турнира
     */
    private String name;

    /**
     * Тип турнира
     */
    private int type;


    /**
     * Метод преобразовывает сущность турнира в модель турнира
     *
     * @param entity сущность турнира
     * @return модель турнира
     */
    public static Tournament toModel(TournamentEntity entity) {
        Tournament model = new Tournament();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setType(entity.getType());
        model.setPlayers(entity.getPlayers().stream().map(Player::toModel).collect(Collectors.toList()));
        model.setDisciplines(entity.getDisciplines().stream().map(Discipline::toModel).collect(Collectors.toList()));
        return model;
    }

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Discipline> getDisciplines() { return disciplines; }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
