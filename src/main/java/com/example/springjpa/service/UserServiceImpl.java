package com.example.springjpa.service;

import com.example.springjpa.model.User;
import com.example.springjpa.repository.UserRepository;

import javax.transaction.Transactional;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}
