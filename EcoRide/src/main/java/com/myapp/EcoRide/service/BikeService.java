package com.myapp.EcoRide.service;

import com.myapp.EcoRide.model.Bike;
import com.myapp.EcoRide.repository.BikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepo bikeRepo;

    public List<Bike> getAvailableBikes() {
        return bikeRepo.findByAvailabilityTrue();
    }
}