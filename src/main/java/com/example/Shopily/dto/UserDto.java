package com.example.Shopily.dto;

public class UserDto {
    private String email; // this will be used as the username
    private String contactNumber;
    private String password;
    private String role; // "shop_owner" or "consumer"
    private String name; // for consumers
    private String shopName; // for shop owners
    private String location; // for shop owners
    private String address; // for shop owners
    private String shopType; // for shop owners
    private String shopPhoto; // for shop owners
    private String otp; // field for OTP

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
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
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}
