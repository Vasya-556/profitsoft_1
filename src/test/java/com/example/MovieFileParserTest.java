package com.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieFileParserTest {

    @Test
    public void testParseValidJson() throws Exception {

        File tmp = File.createTempFile("movies", ".json");
        tmp.deleteOnExit();

        String json = """
        [
          {
            "title": "Inception",
            "director": { "name": "Christopher Nolan" },
            "year": 2010,
            "genres": "Sci-Fi, Thriller"
          }
        ]
        """;

        try (FileWriter fw = new FileWriter(tmp)) {
            fw.write(json);
        }

        MovieFileParser parser = new MovieFileParser();
        List<Movie> movies = parser.parseFile(tmp);

        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
        assertEquals("Christopher Nolan", movies.get(0).getDirector().getName());
        assertEquals(2010, movies.get(0).getYear());
        assertEquals("Sci-Fi, Thriller", movies.get(0).getGenres());
    }
}