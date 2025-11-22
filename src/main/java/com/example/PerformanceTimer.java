package com.example;

import java.util.List;
import java.util.Map;

public class PerformanceTimer {

    public static void measure(String folder, String attribute, int[] threadsArray) {
        MovieProcessingExecutor executor = new MovieProcessingExecutor();
        StatisticsCalculator calculator = new StatisticsCalculator();

        for (int threads : threadsArray) {
            long start = System.nanoTime();

            List<Movie> movies = executor.processFolder(folder, threads);

            Map<String, Long> stats = calculator.calculate(movies, attribute);

            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%d Threads: %.4f milliseconds%n", threads, ms);
        }
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java -cp ... PerformanceTimer <folder> <attribute>");
            System.out.println("Example: mvn -q exec:java -Dexec.mainClass=\"com.example.PerformanceTimer\" -Dexec.args=\"./movies genres\"");
            return;
        }

        String folder = args[0];
        String attribute = args[1];

        int[] threadsArray = {1, 2, 4, 8};

        measure(folder, attribute, threadsArray);
    }
}