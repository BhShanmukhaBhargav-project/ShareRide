package com.myapp.EcoRide.repository;

import com.myapp.EcoRide.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
    // You can add custom query methods here if needed
}
