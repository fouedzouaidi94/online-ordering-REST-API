package com.example.customerproject.Controllers;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.customerproject.Entities.OrderDetails;
import com.example.customerproject.Services.CustomerService;
import com.example.customerproject.Services.OrderDetailsService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
	
	@GetMapping("/api/CustomerPlusCommandes")
	public void CustomerPlusCommandes() {
        customerService.CustomerPlusCommandes();;
	}

	@GetMapping("/api/CustomerPlusDepenses")
	public void CustomerPlusDepense() {
        customerService.CustomerPlusDepenses();;
	}

	@GetMapping("/api/CustomerOrderPlus10Kg")
	public void CustomerOrderPlus10Kg(@RequestParam String dateDebut, @RequestParam String dateFin) {
        customerService.CustomerOrderPlus10Kg(dateDebut, dateFin);
	}
}
