package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsCalculatorTest {

    @Test
    public void testCountByDirector() {
        List<Movie> movies = List.of(
                new Movie("A", new Director("X"), 2000, "Drama"),
                new Movie("B", new Director("X"), 2001, "Action"),
                new Movie("C", new Director("Y"), 2002, "Drama")
        );

        StatisticsCalculator calc = new StatisticsCalculator();
        Map<String, Long> result = calc.calculate(movies, "director");

        assertEquals(2L, result.get("X"));
        assertEquals(1L, result.get("Y"));
    }

    @Test
    public void testCountByGenres() {
        List<Movie> movies = List.of(
                new Movie("A", new Director("X"), 2000, "Drama, Crime"),
                new Movie("B", new Director("X"), 2001, "Drama"),
                new Movie("C", new Director("Y"), 2002, "Crime")
        );

        StatisticsCalculator calc = new StatisticsCalculator();
        Map<String, Long> result = calc.calculate(movies, "genres");

        assertEquals(2L, result.get("Drama"));
        assertEquals(2L, result.get("Crime"));
    }

    @Test
    public void testCountByYear() {
        List<Movie> movies = List.of(
                new Movie("A", new Director("X"), 2000, "Drama"),
                new Movie("B", new Director("X"), 2000, "Action")
        );

        StatisticsCalculator calc = new StatisticsCalculator();
        Map<String, Long> result = calc.calculate(movies, "year");

        assertEquals(2L, result.get("2000"));
    }
}