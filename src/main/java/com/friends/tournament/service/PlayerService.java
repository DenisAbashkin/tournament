package com.friends.tournament.service;

import com.friends.tournament.entity.PlayerEntity;
import com.friends.tournament.exception.AlreadyExistException;
import com.friends.tournament.exception.PlayerNotFoundException;
import com.friends.tournament.model.Player;
import com.friends.tournament.repository.PlayerRepository;
import com.friends.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TournamentRepository tournamentRepository;

    /**
     * Метод добавляет нового игрока
     *
     * @param player сущность нового игрока
     * @return сохранение игрока в репозиторий
     * @throws AlreadyExistException ошибка "Такой игрок уже существует"
     */
    public PlayerEntity addPlayer(PlayerEntity player) throws AlreadyExistException {
        if (playerRepository.findByName(player.getName()) != null) {
            throw new AlreadyExistException("Игрок с таким именем уже существует");
        }
        return playerRepository.save(player);
    }

    /**
     * Метод возвращает всех игроков
     *
     * @return лист игроков в виде моделей
     */
    public List<Player> getAllPlayers() throws PlayerNotFoundException {
        List<PlayerEntity> players = playerRepository.findAll();
        return players.stream().map(Player::toModel).toList();
    }

    /**
     * Метод возвращает модель игрока по id
     *
     * @param id индентификатор игрока
     * @return модель игрока
     * @throws PlayerNotFoundException ошибка "нет такого игркоа"
     */
    public Player findById(Long id) throws PlayerNotFoundException {
        PlayerEntity player = playerRepository.findById(id).get();
        if (player == null) {
            throw new PlayerNotFoundException(id);
        }
        return Player.toModel(player);
    }

    /**
     * Метод обновляет информацию о игроке по id
     *
     * @param newPlayer новая информация о игроке
     * @param id        индентификатор игрока
     * @return сохранение новой информации о игроке
     */
    public PlayerEntity updatePlayer(PlayerEntity newPlayer, Long id) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    /**
     * Метод удаляет игрока по id
     *
     * @param id индентификатор игрока
     * @return сообщение о удалении игрока
     */
    public String deletePlayer(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotFoundException(id);
        }
        playerRepository.deleteById(id);
        return "Player with id " + id + "has been deleted";
    }
}
