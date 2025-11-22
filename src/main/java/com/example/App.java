package com.example;

import java.io.File;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: java -jar demo.jar <folder> <attribute> <threads>");
            System.out.println("Example: java -jar demo.jar ./movies genres 4");
            return;
        }

        String folder = args[0];
        String attribute = args[1];
        int threads = Integer.parseInt(args[2]);

        MovieProcessingExecutor executor = new MovieProcessingExecutor();
        StatisticsCalculator calculator = new StatisticsCalculator();
        StatisticsXmlWriter writer = new StatisticsXmlWriter();

        System.out.println("Reading files...");
        List<Movie> movies = executor.processFolder(folder, threads);

        System.out.println("Calculating statistics...");
        Map<String, Long> stats = calculator.calculate(movies, attribute);

        File out = new File("statistics_by_" + attribute + ".xml");
        writer.write(stats, attribute, out);

        System.out.println("DONE. Output: " + out.getAbsolutePath());
    }
}