package com.example.customerproject.Entities;
import lombok.Getter;

public enum OrderStatus {
	
	CREATE(0), SHIPPING(1), DELIVERED(2), POIDS(3);
	
	@Getter private int displayValue;
	
	private OrderStatus(int dispVal) {
		displayValue=dispVal;
	}

}