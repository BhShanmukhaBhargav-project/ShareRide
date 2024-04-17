package com.myapp.EcoRide.controller;

import com.myapp.EcoRide.model.Bike;
import com.myapp.EcoRide.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/available")
    public List<Bike> getAvailableBikes() {
        return bikeService.getAvailableBikes();
    }

    @PostMapping("/bike/pickup/{id}")
    public ResponseEntity<String> pickupBike(@PathVariable int id, @RequestBody String zNumber) {
        bikeService.updateZNumberAfterPickup(id, zNumber);
        return ResponseEntity.ok("Bike picked up successfully");
    }

    @PostMapping("/bike/dropoff/{id}")
    public ResponseEntity<String> dropoffBike(@PathVariable int id, @RequestBody String location) {
        bikeService.updateLocationAfterDropoff(id, location);
        return ResponseEntity.ok("Bike dropped off successfully");
    }
}
