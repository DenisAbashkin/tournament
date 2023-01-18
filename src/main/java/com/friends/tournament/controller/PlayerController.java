package com.friends.tournament.controller;

import com.friends.tournament.exception.PlayerNotFoundException;
import com.friends.tournament.model.Player;
import com.friends.tournament.repository.PlayerRepository;
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
    private PlayerRepository playerRepository;

    /**
     * Метод добавляет нового игрока
     *
     * @param newPlayer новый игрок
     * @return сохранение игрока в репозиторий
     */
    @PostMapping("/addplayer")
    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    /**
     * Метод возвращает всех игроков
     *
     * @return лист игроков
     */
    @GetMapping("/players")
    List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Метод возвращает игрока по id
     *
     * @param id индентифекатор игрока
     * @return сущность игрока с заданным id
     */
    @GetMapping("/player/{id}")
    Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    /**
     * Метод обновляет значения игрока по id
     *
     * @param id индентифекатор игрока
     * @return ошибку или сохраняет изменения
     */
    @PutMapping("/player/{id}")
    Player updatePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setUsername(newPlayer.getUsername());
                    player.setEmail(newPlayer.getEmail());
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    /**
     * Метод удаляет игрока по id
     *
     * @param id индентифекатор игрока
     * @return ошибку или удаляет игрока
     */
    @DeleteMapping("/player/{id}")
    String deletePlayer(@PathVariable Long id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotFoundException(id);
        }
        playerRepository.deleteById(id);
        return "Player with id " + id + "has been deleted";
    }
}
