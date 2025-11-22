package com.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void testAppRuns() throws Exception {
        File folder = new File(System.getProperty("java.io.tmpdir"), "test_movies");
        folder.mkdir();
        folder.deleteOnExit();

        File movieFile = new File(folder, "movie.json");
        try (FileWriter fw = new FileWriter(movieFile)) {
            fw.write("""
            [
              { "title": "Inception", "director": { "name": "Christopher Nolan" }, "year": 2010, "genres": "Sci-Fi, Thriller" }
            ]
            """);
        }
        movieFile.deleteOnExit();

        String[] args = { folder.getAbsolutePath(), "genres", "2" };
        App.main(args);

        File out = new File("statistics_by_genres.xml");
        assertTrue(out.exists() && out.length() > 0);
        out.deleteOnExit();
    }
}