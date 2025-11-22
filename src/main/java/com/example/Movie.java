package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private String title;
    private Director director;

    @JsonProperty("year")
    private int year;

    private String genres;

    public Movie() {}

    public Movie(String title, Director director, int year, String genres) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String getGenres() {
        return genres;
    }
}