package com.friends.tournament.service;

import com.friends.tournament.entity.TournamentEntity;
import com.friends.tournament.exception.AlreadyExistException;
import com.friends.tournament.exception.PlayerNotFoundException;
import com.friends.tournament.exception.TournamentNotFoundException;
import com.friends.tournament.model.Tournament;
import com.friends.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    /**
     * Метод добавляет новый турнир
     *
     * @param tournament сущность нового турнира
     * @return сохранение турнира в репозиторий
     * @throws AlreadyExistException ошибка "Такой турнир уже существует"
     */
    public TournamentEntity addTournament(TournamentEntity tournament) throws AlreadyExistException {
        if (tournamentRepository.findByName(tournament.getName()) != null) {
            throw new AlreadyExistException("Турнир с таким именем уже существует");
        }
        return tournamentRepository.save(tournament);
    }

    /**
     * Метод возвращает все созданные турниры
     *
     * @return лист турниров в виде моделей
     */
    public List<Tournament> getAllTournaments() {
        List<TournamentEntity> tournament = tournamentRepository.findAll();
        return tournament.stream().map(Tournament::toModel).toList();
    }

    /**
     * Метод возвращает модель турнира по id
     *
     * @param id индентификатор турнира
     * @return модель турнира
     * @throws TournamentNotFoundException ошибка "нет такого турнира"
     */
    public Tournament findById(Long id) throws TournamentNotFoundException {
        TournamentEntity tournament = tournamentRepository.findById(id).get();
        if (tournament == null) {
            throw new TournamentNotFoundException(id);
        }
        return Tournament.toModel(tournament);
    }

    /**
     * Метод удаляет турнир по id
     *
     * @param id индентификатор турнира
     * @return сообщение о удалении турнира
     */
    public String deleteTournament(Long id) {
        if (!tournamentRepository.existsById(id)) {
            throw new TournamentNotFoundException(id);
        }
        tournamentRepository.deleteById(id);
        return "Tournament with id " + id + "has been deleted";
    }

}
