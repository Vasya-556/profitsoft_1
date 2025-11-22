package com.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieProcessingExecutorTest {

    @Test
    public void testProcessFolder() throws Exception {
        File folder = new File(System.getProperty("java.io.tmpdir"), "movies");
        folder.mkdir();
        folder.deleteOnExit();

        File movieFile = new File(folder, "movie.json");
        try (FileWriter fw = new FileWriter(movieFile)) {
            fw.write("""
                [
                    { "title": "Inception", "director": { "name": "Christopher Nolan" }, "year": 2010, "genres": "Sci-Fi" }
                ]
                """);
        }
        movieFile.deleteOnExit();

        MovieProcessingExecutor executor = new MovieProcessingExecutor();
        List<Movie> movies = executor.processFolder(folder.getAbsolutePath(), 2);

        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
    }
}