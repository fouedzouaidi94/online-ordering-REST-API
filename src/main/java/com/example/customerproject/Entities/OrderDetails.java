package com.example.customerproject.Entities;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class OrderDetails {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int qty;
    private float tax;

    @ManyToOne
    private OrderEntity orderEntity;

    @ManyToOne
    private Item item;
}
