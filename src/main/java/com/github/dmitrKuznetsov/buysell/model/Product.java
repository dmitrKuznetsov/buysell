package com.github.dmitrKuznetsov.buysell.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;
}
