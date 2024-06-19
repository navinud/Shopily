package com.example.Shopily.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;

@Document(collection = "items")
@Data
public class Item {
    @Id
    private String id;
    private String name;
    private double price;

    @DBRef
    private Shop shop;

    // getters and setters
}
