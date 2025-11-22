package com.example;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsXmlWriterTest {

    @Test
    public void testWriteXml() throws Exception {
        File tmp = File.createTempFile("stats", ".xml");
        tmp.deleteOnExit();

        StatisticsXmlWriter writer = new StatisticsXmlWriter();
        writer.write(Map.of("Action", 3L, "Drama", 2L), "genres", tmp);

        assertTrue(tmp.exists());
        assertTrue(tmp.length() > 0);
    }
}