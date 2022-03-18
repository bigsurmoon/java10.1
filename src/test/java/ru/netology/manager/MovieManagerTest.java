package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Items;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class MovieManagerTest {

    private Items first = new Items(1, "https://kinopoisk.ru", "Bloodshote", "Action");
    private Items second = new Items(2, "https://kinopoisk.ru", "Onforward", "Cartoon");
    private Items third = new Items(3, "https://kinopoisk.ru", "Hotel Belgrade", "Romantic Comedy");
    private Items fourth = new Items(4, "https://kinopoisk.ru", "The Gentlemen", "Action/Comedy");
    private Items fifth = new Items(5, "https://kinopoisk.ru", "The Invisible Man", "Horror");
    private Items sixth = new Items(6, "https://kinopoisk.ru", "Trolls World Tour", "Cartoon");
    private Items seventh = new Items(7, "https://kinopoisk.ru", "Number One", "Comedy");
    private Items eights = new Items(8, "https://kinopoisk.ru", "Interstellar", "Sci-Fi");
    private Items ninth = new Items(9, "https://kinopoisk.ru", "Star Wars: Episode V", "Sci-Fi");
    private Items tenth = new Items(10, "https://kinopoisk.ru", "Seven", "Thriller");

    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Items[] actual = manager.getAll();
        Items[] expected = new Items[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesOverTheLimit() {
        MovieManager manager = new MovieManager(7);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eights);
        manager.add(ninth);

        Items[] actual = manager.getLastMovie();
        Items[] expected = new Items[]{ninth, eights, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eights);
        manager.add(ninth);

        Items[] actual = manager.getLastMovie();
        Items[] expected = new Items[]{ninth, eights, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetResultLessThanZero (){
        MovieManager manager = new MovieManager(-5);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Items[] actual = manager.getLastMovie();
        Items[] expected = new Items[] {};
        assertArrayEquals(expected, actual);
    }
}