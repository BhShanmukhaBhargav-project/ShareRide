package com.myapp.EcoRide.service;

import com.myapp.EcoRide.model.Location;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LocationService {
    List<Location> getAllLocations();
}
