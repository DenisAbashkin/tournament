package com.friends.tournament.exception;

/**
 * Класс для работы с ошибкой игрок не найден
 */
public class PlayerNotFoundException extends RuntimeException{
    /**
     * Метод возвращает текст ошибки с id
     * @param id индентификатор игрока
     */
    public PlayerNotFoundException(Long id) {
        super("Нет пользователя с таким id: " + id);
    }
}
