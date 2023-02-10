package com.friends.tournament.controller;

import com.friends.tournament.entity.PlayerEntity;
import com.friends.tournament.exception.AlreadyExistException;
import com.friends.tournament.model.Player;
import com.friends.tournament.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с сущностью игрока
 */
@RestController
@CrossOrigin("${FRONT_URL}")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * Метод добавляет нового игрока
     *
     * @param newPlayer новый игрок
     * @return сохранение игрока в репозиторий
     */
    @PostMapping("/addplayer")
    PlayerEntity addPlayer(@RequestBody PlayerEntity newPlayer) throws AlreadyExistException {
        return playerService.addPlayer(newPlayer);
    }

    /**
     * Метод возвращает всех игроков
     *
     * @return лист игроков
     */
    @GetMapping("/players")
    List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    /**
     * Метод возвращает игрока по id
     *
     * @param id индентифекатор игрока
     * @return сущность игрока с заданным id
     */
    @GetMapping("/player/{id}")
    Player getPlayerById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    /**
     * Метод обновляет значения игрока по id
     *
     * @param id индентифекатор игрока
     * @return ошибку или сохраняет изменения
     */
    @PutMapping("/updateplayer/{id}")
    PlayerEntity updatePlayer(@RequestBody PlayerEntity newPlayer, @PathVariable Long id) {
        return playerService.updatePlayer(newPlayer, id);
    }

    /**
     * Метод удаляет игрока по id
     *
     * @param id индентифекатор игрока
     * @return ошибку или удаляет игрока
     */
    @DeleteMapping("/player/{id}")
    String deletePlayer(@PathVariable Long id) {
        return playerService.deletePlayer(id);
    }
}
