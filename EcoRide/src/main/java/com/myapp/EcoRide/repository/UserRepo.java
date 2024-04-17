package com.myapp.EcoRide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.EcoRide.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByzNumber(String zNumber);
}
