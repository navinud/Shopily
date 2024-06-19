package com.example.Shopily.repository;

import com.example.Shopily.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByShopId(String shopId);
    List<Item> findByNameContaining(String name);
}
