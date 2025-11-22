package com.example;

import java.io.File;
import java.util.List;

public class MovieFileParser {

    private final MovieJsonReader reader = new MovieJsonReader();

    public List<Movie> parseFile(File file) {
        return reader.readMovies(file);
    }
}