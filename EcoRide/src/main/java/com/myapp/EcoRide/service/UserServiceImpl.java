package com.myapp.EcoRide.service;

import com.myapp.EcoRide.model.User;
import com.myapp.EcoRide.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByzNumber(String zNumber) {
        return userRepo.findByzNumber(zNumber);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
