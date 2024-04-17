package com.myapp.EcoRide.repository;

import com.myapp.EcoRide.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BikeRepo extends JpaRepository<Bike, Integer> {
    List<Bike> findByAvailabilityTrue();
}
