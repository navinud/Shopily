package com.example.Shopily.service;

import com.example.Shopily.dto.ShopDto;
import com.example.Shopily.model.Shop;
import com.example.Shopily.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Shop addShop(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        shop.setLocation(shopDto.getLocation());
        // Set other properties as needed

        return shopRepository.save(shop);
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop getShopById(String id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    // Additional methods as needed
}
