package com.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MovieJsonReader {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Movie> readMovies(File file) {
        List<Movie> result = new ArrayList<>();

        try (JsonParser parser = new JsonFactory().createParser(file)) {

            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalArgumentException("JSON root must be an array");
            }

            while (parser.nextToken() == JsonToken.START_OBJECT) {
                Movie movie = mapper.readValue(parser, Movie.class);
                result.add(movie);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error parsing file: " + file.getName(), e);
        }

        return result;
    }
}