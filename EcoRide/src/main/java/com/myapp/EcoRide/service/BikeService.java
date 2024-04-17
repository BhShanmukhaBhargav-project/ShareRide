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

    public void updateZNumberAfterPickup(int id, String zNumber) {
        Bike bike = bikeRepo.findById(id).orElse(null);
        if (bike != null && bike.isAvailability()) {
            bike.setUserZNumber(zNumber);
            bikeRepo.save(bike);
        }
    }

    public void updateLocationAfterDropoff(int id, String location) {
        Bike bike = bikeRepo.findById(id).orElse(null);
        if (bike != null && !bike.isAvailability()) {
            bike.setLocationAfterDropoff(location);
            bikeRepo.save(bike);
        }
    }
}
