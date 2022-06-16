package com.example.customerproject.Entities;
import javax.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
public class Item {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private float weight;
    private String description;
    private float price;

    @OneToMany(mappedBy= "item")
    private List<OrderDetails> orderDetails;
}
