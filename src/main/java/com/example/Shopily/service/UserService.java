package com.example.Shopily.service;

import com.example.Shopily.dto.UserDto;
import com.example.Shopily.model.User;
import com.example.Shopily.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        // Set other properties as needed

        return userRepository.save(user);
    }

    // Additional methods as needed
}
