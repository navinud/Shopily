package com.example.Shopily.controller;

import com.example.Shopily.dto.ShopDto;
import com.example.Shopily.model.Shop;
import com.example.Shopily.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ResponseEntity<Shop> addShop(@RequestBody ShopDto shopDto) {
        Shop newShop = shopService.addShop(shopDto);
        return new ResponseEntity<>(newShop, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable String id) {
        Shop shop = shopService.getShopById(id);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    // Additional endpoints as needed
}
