package com.example.Shopily.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class ShopOwner extends User {
    private String shopName;
    private String location;
    private String address;
    private String shopType;
    private String shopPhoto;

    // Constructors, getters and setters
    public ShopOwner() {
        super();
    }

    public ShopOwner(String email, String contactNumber, String password, String shopName, String location, String address, String shopType, String shopPhoto) {
        super(email, contactNumber, password, "shop_owner");
        this.shopName = shopName;
        this.location = location;
        this.address = address;
        this.shopType = shopType;
        this.shopPhoto = shopPhoto;
    }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getShopType() { return shopType; }
    public void setShopType(String shopType) { this.shopType = shopType; }
    public String getShopPhoto() { return shopPhoto; }
    public void setShopPhoto(String shopPhoto) { this.shopPhoto = shopPhoto; }
}
