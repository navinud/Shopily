package com.example.Shopily.dto;

public class UserDto {
    private String username; // this will be the email
    private String email;
    private String otp; // new field for OTP

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}

