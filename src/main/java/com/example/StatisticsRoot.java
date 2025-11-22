package com.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "statistics")
public class StatisticsRoot {

    @XmlElement(name = "item")
    public List<StatisticsItem> items = new ArrayList<>();
}