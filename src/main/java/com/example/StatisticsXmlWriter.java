package com.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.Map;

public class StatisticsXmlWriter {

    public void write(Map<String, Long> stats, String attribute, File output) {

        try {
            StatisticsRoot root = new StatisticsRoot();

            stats.entrySet().stream()
                    .sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                    .forEach(e -> root.items.add(
                            new StatisticsItem(e.getKey(), e.getValue())
                    ));

            JAXBContext ctx = JAXBContext.newInstance(StatisticsRoot.class, StatisticsItem.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(root, output);

        } catch (Exception e) {
            throw new RuntimeException("Error writing XML", e);
        }
    }
}