package com.example.Shopily.controller;

import com.example.Shopily.dto.UserDto;
import com.example.Shopily.model.User;
import com.example.Shopily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        User newUser = userService.registerUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody UserDto userDto) {
        boolean isOtpValid = userService.verifyOtp(userDto.getEmail(), userDto.getOtp());
        if (isOtpValid) {
            userService.saveUser(userDto);
            return new ResponseEntity<>("OTP verified successfully. User registered.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid OTP.", HttpStatus.BAD_REQUEST);
        }
    }
}
