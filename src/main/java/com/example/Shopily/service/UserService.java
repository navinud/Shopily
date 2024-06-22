package com.example.Shopily.service;

import com.example.Shopily.dto.UserDto;
import com.example.Shopily.model.User;
import com.example.Shopily.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService; // service to send email

    private Map<String, String> otpStore = new HashMap<>(); // in-memory store for OTPs

    public User registerUser(UserDto userDto) {
        // Generate OTP
        String otp = generateOtp();
        otpStore.put(userDto.getEmail(), otp);

        // Send OTP to user's email
        emailService.sendOtpEmail(userDto.getEmail(), otp);

        // Create User object but do not save it yet
        User user = new User();
        user.setUsername(userDto.getEmail());
        user.setEmail(userDto.getEmail());

        // Return user object without saving to prompt OTP verification
        return user;
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
        User user = new User();
        user.setUsername(userDto.getEmail());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }
}

