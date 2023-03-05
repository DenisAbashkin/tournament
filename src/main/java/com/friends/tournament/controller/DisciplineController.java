package com.friends.tournament.controller;

import com.friends.tournament.exception.DisciplineNotFoundException;
import com.friends.tournament.exception.PlayerNotFoundException;
import com.friends.tournament.model.Discipline;
import com.friends.tournament.model.Player;
import com.friends.tournament.model.Tournament;
import com.friends.tournament.repository.DisciplineRepository;
import com.friends.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("${FRONT_URL}")
public class DisciplineController {

    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private TournamentRepository tournamentRepository;

    /**
     * Метод добавляет новую дисциплину
     *
     * @param newDiscipline новая дисциплина
     * @return сохранение дисциплины в репозиторий
     */

    @PostMapping("/adddiscipline")
    Discipline newDiscipline(@RequestBody Discipline newDiscipline) throws DisciplineNotFoundException{
        return disciplineRepository.save(newDiscipline);
    }

    /**
     * Метод возвращает все дисциплины
     *
     * @return лист дисциплин
     */
    @GetMapping("/disciplines")
    List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    /**
     * Метод возвращает дисциплину по id
     *
     * @param id индентифекатор дисциплины
     * @return сущность дисциплины с заданным id
     */
    @GetMapping("/discipline/{id}")
    Discipline getDisciplineById(@PathVariable Long id) {
        return disciplineRepository.findById(id)
                .orElseThrow(() -> new DisciplineNotFoundException(id));
    }

    /**
     * Метод обновляет значения игрока по id
     *
     * @param id индентифекатор игрока
     * @return ошибку или сохраняет изменения
     */
    @PutMapping("/discipline/{id}")
    Discipline updateDiscipline(@RequestBody Discipline newDiscipline, @PathVariable Long id) {
        return disciplineRepository.findById(id)
                .map(discipline -> {
                    discipline.setName(newDiscipline.getName());
                    discipline.setName(newDiscipline.getName());
                    return disciplineRepository.save(discipline);
                })
                .orElseThrow(() -> new DisciplineNotFoundException(id));
    }

    /**
     * Метод удаляет игрока по id
     *
     * @param id индентифекатор игрока
     * @return ошибку или удаляет игрока
     */
    @DeleteMapping("/discipline/{id}")
    String deleteDiscipline(@PathVariable Long id) {
        if (!disciplineRepository.existsById(id)) {
            throw new DisciplineNotFoundException(id);
        }
        disciplineRepository.deleteById(id);
        return "Discipline with id " + id + "has been deleted";
    }
}
