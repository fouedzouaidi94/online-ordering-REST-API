package com.example.customerproject.Entities;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Delivery {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String deliveryMan;
    private LocalDate shoppingDate;
    private LocalDate deliveryDate;

    @ManyToOne
    private OrderEntity orderEntity;
}
