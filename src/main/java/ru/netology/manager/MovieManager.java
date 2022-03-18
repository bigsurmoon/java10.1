package ru.netology.manager;

import ru.netology.domain.Items;

public class MovieManager {

    private Items[] movies = new Items[0];
    private int resultLength = 10;

    public MovieManager() {
    }

    public MovieManager(int resultLength) {
        if (resultLength < 0) {
            resultLength = 0;
        }
        this.resultLength = resultLength;
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
        if (movies.length < resultLength) {
            resultLength = movies.length;
        }
        Items[] result = new Items[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}