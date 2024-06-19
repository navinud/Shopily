package com.example.Shopily.controller;

import com.example.Shopily.dto.ItemDto;
import com.example.Shopily.model.Item;
import com.example.Shopily.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody ItemDto itemDto) {
        Item newItem = itemService.addItem(itemDto);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<List<Item>> getItemsByShop(@PathVariable String shopId) {
        List<Item> items = itemService.getItemsByShop(shopId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItemsByName(@RequestParam String name) {
        List<Item> items = itemService.searchItemsByName(name);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Additional endpoints as needed
}
