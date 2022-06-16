package com.example.customerproject.Entities;

import javax.persistence.*;

import lombok.Data;

import java.util.List;
import java.util.Comparator;


@Entity
@Data
public class Customer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String name;
    private String deliveryAddress;
    private String contact;
    private Boolean active;

    @OneToMany(mappedBy= "customer")
    private List<OrderEntity> orderEntities;

    @Transient
    public static Comparator<Customer> ComparatorOrders = new Comparator<Customer>() {
     
        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c2.getOrderEntities().size() - c1.getOrderEntities().size());
        }
    };
    
}
