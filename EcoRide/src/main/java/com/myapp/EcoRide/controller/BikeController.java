package com.myapp.EcoRide.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.EcoRide.model.Bike;
import com.myapp.EcoRide.model.User;
import com.myapp.EcoRide.repository.BikeRepo;
import com.myapp.EcoRide.repository.UserRepo;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    private final BikeRepo bikeRepository;
    private final UserRepo userRepository;

    public BikeController(BikeRepo bikeRepository, UserRepo userRepository) {
        this.bikeRepository = bikeRepository;
        this.userRepository = userRepository;
    }

    @PutMapping("/rent")
    public ResponseEntity<?> rentBike(@RequestBody Map<String, Object> requestBody) {
        Integer bikeId = null;
        String userId = null;

        if (requestBody.containsKey("bikeId")) {
            bikeId = (int) ((Number) requestBody.get("bikeId")).longValue();
        }

        if (requestBody.containsKey("userId")) {
            userId = (String) requestBody.get("userId");
        }

        if (bikeId == null || userId == null) {
            return ResponseEntity.badRequest().body("Both bikeId and userId must be provided in the request body.");
        }

        Optional<Bike> bikeOptional = bikeRepository.findById(bikeId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (bikeOptional.isEmpty() || userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Bike bike = bikeOptional.get();
        User user = userOptional.get();

        bike.setUser(user);
        bikeRepository.save(bike);

        return ResponseEntity.ok("Bike rented successfully!");
    }
    @PutMapping("/return")
    public ResponseEntity<?> returnBike(@RequestBody Map<String, Object> requestBody) {
        Integer bikeId = null;
        String userId = null;
        String location = null;

        if (requestBody.containsKey("bikeId")) {
            bikeId = (int) ((Number) requestBody.get("bikeId")).longValue();
        }

        if (requestBody.containsKey("userId")) {
            userId = (String) requestBody.get("userId");
        }

        if (requestBody.containsKey("location")) {
            location = (String) requestBody.get("location");
        }

        if (bikeId == null || userId == null || location == null) {
            return ResponseEntity.badRequest().body("bikeId, userId, and location must be provided in the request body.");
        }

        Optional<Bike> bikeOptional = bikeRepository.findById(bikeId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (bikeOptional.isEmpty() || userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Bike bike = bikeOptional.get();
        User user = userOptional.get();

        bike.setUser(user);
        bike.setLocation(location);
        bikeRepository.save(bike);

        return ResponseEntity.ok("Bike returned successfully! Location updated.");
    }
}
