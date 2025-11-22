package com.example;

import jakarta.xml.bind.annotation.XmlElement;

public class StatisticsItem {

    @XmlElement
    private String value;

    @XmlElement
    private long count;

    public StatisticsItem() {}

    public StatisticsItem(String value, long count) {
        this.value = value;
        this.count = count;
    }

    public String getValue() { return value; }
    public long getCount() { return count; }
}