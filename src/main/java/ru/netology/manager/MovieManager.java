package ru.netology.manager;

import ru.netology.domain.Items;

public class MovieManager {

    private Items[] movies = new Items[0];
    private int moviesCount = 10;

    public MovieManager() {
    }

    public MovieManager(int moviesCount) {
        this.moviesCount = moviesCount;
    }

    public void add(Items movie) {
        int length = movies.length + 1;
        Items[] tmp = new Items[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Items[] getAll() {
        Items[] result = new Items[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Items[] getLastMovie() {
        int resultLength;
        if (movies.length < moviesCount) {
            resultLength = movies.length;
        }
        else {
            resultLength = moviesCount;
        }
        Items[] result = new Items[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}