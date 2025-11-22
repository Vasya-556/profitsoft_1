package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsItemTest {

    @Test
    public void testConstructorAndGetters() {
        StatisticsItem item = new StatisticsItem("value", 5L);
        assertEquals("value", item.getValue());
        assertEquals(5L, item.getCount());
    }
}