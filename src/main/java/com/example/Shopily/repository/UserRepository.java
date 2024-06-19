package com.example.Shopily.repository;

import com.example.Shopily.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom queries if needed
}
