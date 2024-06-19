package com.example.Shopily.repository;

import com.example.Shopily.model.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Shop, String> {
    // Custom queries if needed
}
