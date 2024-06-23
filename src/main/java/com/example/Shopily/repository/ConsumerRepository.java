package com.example.Shopily.repository;

import com.example.Shopily.model.Consumer;
import com.example.Shopily.model.ShopOwner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConsumerRepository extends MongoRepository<Consumer, String> {
    Optional<Consumer> findByEmail(String email);
}
