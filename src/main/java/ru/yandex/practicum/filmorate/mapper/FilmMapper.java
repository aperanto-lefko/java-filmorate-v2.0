package ru.yandex.practicum.filmorate.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.yandex.practicum.filmorate.dto.film.FilmDto;
import ru.yandex.practicum.filmorate.dto.film.UpdateFilmRequest;
import ru.yandex.practicum.filmorate.model.Director;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Genre;

import java.util.ArrayList;

// Создает приватный конструктор, чтобы предотвратить создание экземпляров класса
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilmMapper {

    // Метод для обновления полей фильма на основе данных из запроса
    public static Film updateFilmFields(Film film, UpdateFilmRequest request) {
        if (request.hasId()) {
            film.setId(request.getId());
        }
        if (request.hasName()) {
            film.setName(request.getName());
        }
        if (request.hasDescription()) {
            film.setDescription(request.getDescription());
        }
        if (request.hasReleaseDate()) {
            film.setReleaseDate(request.getReleaseDate());
        }
        if (request.hasDuration()) {
            film.setDuration(request.getDuration());
        }
        if (request.hasMpa()) {
            film.setMpa(request.getMpa());
        }
        if (request.hasGenre()) {
            film.setGenres(request.getGenres());
        } else {
            film.setGenres(new ArrayList<Genre>());
        }
        if (request.hasDirectors()) {
            film.setDirectors(request.getDirectors());
        } else {
            film.setDirectors(new ArrayList<Director>());
        }
        return film;
    }

    // Метод для преобразования объекта Film в FilmDto
    public static FilmDto toFilmDto(Film film) {
        return FilmDto.builder()
                .id(film.getId())
                .name(film.getName())
                .description(film.getDescription())
                .duration(film.getDuration())
                .releaseDate(film.getReleaseDate())
                .mpa(film.getMpa())
                .genres(film.getGenres())
                .directors(film.getDirectors())
                .build();
    }
}