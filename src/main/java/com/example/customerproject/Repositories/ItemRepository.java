package com.example.customerproject.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customerproject.Entities.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
