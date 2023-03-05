package com.friends.tournament.exception;

public class DisciplineNotFoundException extends RuntimeException {
    /**
     * Метод возвращает текст ошибки с id
     * @param id индентификатор игрока
     */
    public DisciplineNotFoundException(Long id) {
        super("Нет дисциплины с таким id: " + id);
    }
}
