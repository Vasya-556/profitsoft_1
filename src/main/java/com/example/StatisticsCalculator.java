package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsCalculator {

    public Map<String, Long> calculate(List<Movie> movies, String attribute) {
        return switch (attribute) {
            case "director" -> countByDirector(movies);
            case "year" -> countByYear(movies);
            case "genres" -> countByGenres(movies);
            default -> throw new IllegalArgumentException("Unknown attribute: " + attribute);
        };
    }

    private Map<String, Long> countByDirector(List<Movie> movies) {
        return movies.stream()
                .collect(Collectors.groupingBy(
                        m -> m.getDirector().getName(),
                        Collectors.counting()
                ));
    }

    private Map<String, Long> countByYear(List<Movie> movies) {
        return movies.stream()
                .collect(Collectors.groupingBy(
                        m -> String.valueOf(m.getYear()),
                        Collectors.counting()
                ));
    }

    private Map<String, Long> countByGenres(List<Movie> movies) {
        Map<String, Long> map = new HashMap<>();

        for (Movie m : movies) {
            String[] parts = m.getGenres().split(",");
            for (String raw : parts) {
                String g = raw.trim();
                map.put(g, map.getOrDefault(g, 0L) + 1L);
            }
        }

        return map;
    }
}