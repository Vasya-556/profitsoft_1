package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsRootTest {

    @Test
    public void testAddItem() {
        StatisticsRoot root = new StatisticsRoot();
        root.items.add(new StatisticsItem("A", 1));

        assertEquals(1, root.items.size());
        assertEquals("A", root.items.get(0).getValue());
        assertEquals(1, root.items.get(0).getCount());
    }
}