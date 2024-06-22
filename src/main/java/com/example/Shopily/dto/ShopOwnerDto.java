package com.example.Shopily.dto;

public class ShopOwnerDto extends UserDto {
    private String shopName;
    private String location;
    private String address;
    private String shopType;
    private String shopPhoto;

    // Getters and setters
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
