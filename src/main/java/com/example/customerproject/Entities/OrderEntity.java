package com.example.customerproject.Entities;
import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class OrderEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private LocalDate createDate;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy= "orderEntity")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy= "orderEntity")
    private List<OrderDetails> orderDetails;
    
}



