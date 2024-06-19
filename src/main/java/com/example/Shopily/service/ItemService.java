package com.example.Shopily.service;

import com.example.Shopily.dto.ItemDto;
import com.example.Shopily.model.Item;
import com.example.Shopily.model.Shop;
import com.example.Shopily.repository.ItemRepository;
import com.example.Shopily.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShopRepository shopRepository;

    public Item addItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());

        Shop shop = shopRepository.findById(itemDto.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        item.setShop(shop);

        return itemRepository.save(item);
    }

    public List<Item> getItemsByShop(String shopId) {
        return itemRepository.findByShopId(shopId);
    }

    public List<Item> searchItemsByName(String name) {
        return itemRepository.findByNameContaining(name);
    }

    // Additional methods as needed
}
