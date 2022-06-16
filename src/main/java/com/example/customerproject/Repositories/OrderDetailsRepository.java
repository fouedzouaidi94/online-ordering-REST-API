package com.example.customerproject.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customerproject.Entities.OrderDetails;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    
}
