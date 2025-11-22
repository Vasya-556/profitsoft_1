package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MovieProcessingExecutor {

    public List<Movie> processFolder(String folderPath, int threads) {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Folder not found: " + folderPath);
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null || files.length == 0) {
            return List.of();
        }

        ExecutorService pool = Executors.newFixedThreadPool(threads);
        List<Future<List<Movie>>> futures = new ArrayList<>();

        MovieFileParser parser = new MovieFileParser();

        for (File file : files) {
            futures.add(pool.submit(() -> parser.parseFile(file)));
        }

        List<Movie> allMovies = new ArrayList<>();

        for (Future<List<Movie>> f : futures) {
            try {
                allMovies.addAll(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        return allMovies;
    }
}