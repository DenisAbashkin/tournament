package com.friends.tournament.controller;

import com.friends.tournament.entity.TournamentEntity;
import com.friends.tournament.exception.AlreadyExistException;
import com.friends.tournament.model.Tournament;
import com.friends.tournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с сущностью турнира
 */
@RestController
@CrossOrigin("${FRONT_URL}")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    /**
     * Метод добавляет новый турнир
     *
     * @param newTournament сущность нового турнира
     * @return сохранение турнира в репозиторий
     */
    @PostMapping("/addtournament")
    TournamentEntity addTournament(@RequestBody TournamentEntity newTournament) throws AlreadyExistException {
        return tournamentService.addTournament(newTournament);
    }

    /**
     * Метод возвращает все турниры
     *
     * @return лист турниров
     */
    @GetMapping("/tournaments")
    List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }


    /**
     * Метод возвращает турнир по id
     *
     * @param id индентифекатор турнира
     * @return сущность турнира с заданным id
     */
    @GetMapping("/tournament/{id}")
    Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.findById(id);
    }

    /**
     * Метод удаляет турнир по id
     *
     * @param id индентифекатор турнира
     * @return ошибку или удаляет турнир
     */
    @DeleteMapping("/tournament/{id}")
    String deleteTournament(@PathVariable Long id) {
        return tournamentService.deleteTournament(id);
    }
}
