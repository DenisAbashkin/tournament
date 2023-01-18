package com.friends.tournament.exception;

/**
 * Класс для работы с ошибкой турнир не найден
 */
public class TournamentNotFoundException extends RuntimeException{
    /**
     * Метод возвращает текст ошибки с id
     * @param id индентификатор турнира
     */
    public TournamentNotFoundException(Long id) {
        super("Нет турнира с таким id: " + id);
    }
}
