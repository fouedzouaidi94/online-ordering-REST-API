package com.example.customerproject.Controllers;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.customerproject.Entities.OrderDetails;
import com.example.customerproject.Services.OrderDetailsService;
import com.example.customerproject.Services.OrderEntityService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderEntityController {
    private OrderEntityService orderEntityService;
	
	@GetMapping("/api/meilleurLivreur")
	public String meilleurLivreur() {
        return orderEntityService.meilleurLivreur();
	}

    @GetMapping("/api/pireLivreur")
	public String pireLivreur() {
        return orderEntityService.pireLivreur();
	}


}
