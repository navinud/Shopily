package com.example.Shopily.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumers")
public class Consumer extends User {
    private String name;

    // Constructors, getters, and setters
    public Consumer() {
        super();
    }

    public Consumer(String email, String contactNumber, String password, String name) {
        super(email, contactNumber, password, "consumer");
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
