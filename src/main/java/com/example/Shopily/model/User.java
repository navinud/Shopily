package com.example.Shopily.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public abstract class User {
    @Id
    private String id;
    private String email; // this will be used as the username
    private String contactNumber;
    private String password;
    private String role; // "shop_owner" or "consumer"

    // Constructors, getters and setters
    public User() {
    }

    public User(String email, String contactNumber, String password, String role) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
        this.role = role;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
