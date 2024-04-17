package com.myapp.EcoRide.service;

import org.springframework.stereotype.Service;

import com.myapp.EcoRide.model.User;

@Service
public interface UserService {

    User save(User user);

    User findByzNumber(String getzNumber);
}
