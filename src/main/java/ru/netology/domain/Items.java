package ru.netology.domain;

public class Items {

    private int id;
    private String imageUrl;
    private String name;
    private String genre;

    public Items(int id, String imageUrl, String name, String genre) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.genre = genre;
    }
}
