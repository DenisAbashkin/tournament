package com.friends.tournament.controller;

import com.friends.tournament.model.Tournament;
import com.friends.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.friends.tournament.exception.TournamentNotFoundException;

import java.util.List;

/**
 * Контроллер для работы с сущностью турнира
 */
@RestController
@CrossOrigin("${FRONT_URL}")
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    /**
     * Метод добавляет новый турнир
     *
     * @param newTournament сущность нового турнира
     * @return сохранение турнира в репозиторий
     */
    @PostMapping("/addtournament")
    Tournament newTournament(@RequestBody Tournament newTournament) {
        return tournamentRepository.save(newTournament);
    }

    /**
     * Метод возвращает все турниры
     *
     * @return лист турниров
     */
    @GetMapping("/tournaments")
    List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }


    /**
     * Метод возвращает турнир по id
     *
     * @param id индентифекатор турнира
     * @return сущность турнира с заданным id
     */
    @GetMapping("/tournament/{id}")
    Tournament getTournamentById(@PathVariable Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new TournamentNotFoundException(id));
    }

    /**
     * Метод удаляет турнир по id
     *
     * @param id индентифекатор турнира
     * @return ошибку или удаляет турнир
     */
    @DeleteMapping("/tournament/{id}")
    String deleteTournament(@PathVariable Long id) {
        if (!tournamentRepository.existsById(id)) {
            throw new TournamentNotFoundException(id);
        }
        tournamentRepository.deleteById(id);
        return "Турнир с id " + id + "был удален";
    }
}
