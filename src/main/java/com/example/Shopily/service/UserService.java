package com.example.Shopily.service;

import com.example.Shopily.dto.UserDto;
import com.example.Shopily.model.Consumer;
import com.example.Shopily.model.ShopOwner;
import com.example.Shopily.model.User;
import com.example.Shopily.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private Map<String, String> otpStore = new HashMap<>();

    public void registerUser(UserDto userDto) {
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
        }
        return false;
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // generate a 6-digit OTP
        return String.valueOf(otp);
    }

    public User saveUser(UserDto userDto) {
        logger.debug("Saving user with role: " + userDto.getRole());

        User user;
        if ("shop_owner".equals(userDto.getRole())) {
            user = new ShopOwner(userDto.getEmail(), userDto.getContactNumber(), userDto.getPassword(), userDto.getShopName(), userDto.getLocation(), userDto.getAddress(), userDto.getShopType(), userDto.getShopPhoto());
        } else if ("consumer".equals(userDto.getRole())) {
            user = new Consumer(userDto.getEmail(), userDto.getContactNumber(), userDto.getPassword(), userDto.getName());
        } else {
            throw new IllegalArgumentException("Unknown user type");
        }
        return userRepository.save(user);
    }
}