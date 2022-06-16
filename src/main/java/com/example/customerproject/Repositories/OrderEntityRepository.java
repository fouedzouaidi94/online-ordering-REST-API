package com.example.customerproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customerproject.Entities.OrderEntity;


public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {
    
}
