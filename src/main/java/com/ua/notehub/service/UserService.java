package com.ua.notehub.service;

import com.ua.notehub.model.User;
import com.ua.notehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUserId (Long Id) {
        return userRepository.findByUserId(Id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
