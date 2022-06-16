package com.example.customerproject.Controllers;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.customerproject.Entities.OrderDetails;
import com.example.customerproject.Services.OrderDetailsService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderDetailsController {
    private OrderDetailsService OrderDetailsService;
	
	@GetMapping("/api/totalOrders")
	public float TotalPrice(@RequestParam int orderEntityId) {
        return OrderDetailsService.calculateTotal(orderEntityId);
	}

    @GetMapping("/api/totalWeight")
	public float TotalWeight(@RequestParam int orderEntityId) {
        return OrderDetailsService.calculateWeight(orderEntityId);
	}
}
