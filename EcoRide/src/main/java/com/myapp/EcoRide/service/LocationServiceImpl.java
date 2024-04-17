package com.myapp.EcoRide.service;

import com.myapp.EcoRide.model.Location;
import com.myapp.EcoRide.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepo locationRepo;

    @Override
    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }
}
