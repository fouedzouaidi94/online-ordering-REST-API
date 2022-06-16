package com.example.customerproject.Services;

import com.example.customerproject.Entities.Item;
import com.example.customerproject.Entities.OrderDetails;
import com.example.customerproject.Entities.OrderEntity;
import com.example.customerproject.Repositories.ItemRepository;
import com.example.customerproject.Repositories.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class OrderDetailsService {
    private ItemRepository itemRepository;

    //Retourne le total d’ordre inclut le taxe
    public float calculateTotal(int orderEntityId) {
		float totalTaxes = 0;
        float totalPrices = 0;

        for(Item item:itemRepository.findAll()){
            for(OrderDetails orderDetails: item.getOrderDetails()){
                if(orderDetails.getOrderEntity().getId() == orderEntityId){
                    totalPrices = totalPrices + item.getPrice();
                    totalTaxes = totalTaxes + orderDetails.getTax();
                }
            }
        }   
         
        return totalPrices+totalTaxes;
	}

       //Retourne le poids total d’ordre
    public float calculateWeight(int orderEntityId) {
		float totalPoids = 0;

        for(Item item:itemRepository.findAll()){
            for(OrderDetails orderDetails: item.getOrderDetails()){
                if(orderDetails.getOrderEntity().getId() == orderEntityId){
                    totalPoids = totalPoids + item.getWeight();
                }
            }
        }   
         
        return totalPoids;
	}
    
}
