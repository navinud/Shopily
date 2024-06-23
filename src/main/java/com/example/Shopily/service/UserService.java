package com.example.Shopily.service;

import com.example.Shopily.dto.UserDto;
import com.example.Shopily.model.Consumer;
import com.example.Shopily.model.ShopOwner;
import com.example.Shopily.model.User;
import com.example.Shopily.repository.ConsumerRepository;
import com.example.Shopily.repository.ShopOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private ShopOwnerRepository shopOwnerRepository;

    @Autowired
    private EmailService emailService;

    private Map<String, String> otpStore = new HashMap<>();

    public void registerUser(UserDto userDto) {
        // Save user details to the database
        User user;
        if ("shop_owner".equals(userDto.getRole())) {
            user = new ShopOwner(userDto.getEmail(), userDto.getContactNumber(), userDto.getPassword(), userDto.getShopName(), userDto.getLocation(), userDto.getAddress(), userDto.getShopType(), userDto.getShopPhoto());
            shopOwnerRepository.save((ShopOwner) user);
        } else if ("consumer".equals(userDto.getRole())) {
            user = new Consumer(userDto.getEmail(), userDto.getContactNumber(), userDto.getPassword(), userDto.getName());
            consumerRepository.save((Consumer) user);
        } else {
            throw new IllegalArgumentException("Unknown user type");
        }

        // Generate OTP
        String otp = generateOtp();
        otpStore.put(userDto.getEmail(), otp);

        // Send OTP to user's email
        emailService.sendOtpEmail(userDto.getEmail(), otp);
    }

    public boolean verifyOtp(String email, String otp) {
        String storedOtp = otpStore.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            // OTP is correct, remove it from store
            otpStore.remove(email);
            return true;
        } else {
            // OTP is incorrect, delete user details from database
            consumerRepository.findByEmail(email).ifPresent(consumerRepository::delete);
            shopOwnerRepository.findByEmail(email).ifPresent(shopOwnerRepository::delete);
            return false;
        }
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // generate a 6-digit OTP
        return String.valueOf(otp);
    }
}
