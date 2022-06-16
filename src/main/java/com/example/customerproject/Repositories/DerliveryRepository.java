package com.example.customerproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customerproject.Entities.Delivery;

public interface DerliveryRepository extends JpaRepository<Delivery, Integer> {
    
}
