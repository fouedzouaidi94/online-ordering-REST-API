package com.example.customerproject.Services;

import com.example.customerproject.Entities.Delivery;
import com.example.customerproject.Entities.OrderEntity;
import com.example.customerproject.Repositories.OrderEntityRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderEntityService {
    OrderEntityRepository orderEntityRepository;

    // Afficher le livreur qui a une moyenne de temps de livraison la plus rapide
    public String meilleurLivreur(){
        
        List <OrderEntity> orderEntityList = orderEntityRepository.findAll();
        Delivery deliveryObj = orderEntityList.get(0).getDeliveries().get(0);
        LocalDate dt1 = orderEntityList.get(0).getCreateDate();
        LocalDate dt2= deliveryObj.getDeliveryDate();
        long diffDays = ChronoUnit.DAYS.between(dt1, dt2);
        long minDiffDays = diffDays;
        Delivery meilleurDelivery = deliveryObj;

        for(OrderEntity orderEntity: orderEntityRepository.findAll()){
            for(Delivery delivery: orderEntity.getDeliveries()){
                dt1 = orderEntity.getCreateDate();
                dt2 = delivery.getDeliveryDate();
                diffDays = ChronoUnit.DAYS.between(dt1, dt2);
                if(diffDays < minDiffDays){
                    minDiffDays = diffDays;
                    meilleurDelivery = delivery;
                }
            }
        }
        return meilleurDelivery.getDeliveryMan();
    }

    // Afficher le livreur qui a une moyenne de temps de livraison la plus lente
    public String pireLivreur(){
        
        List <OrderEntity> orderEntityList = orderEntityRepository.findAll();
        Delivery deliveryObj = orderEntityList.get(0).getDeliveries().get(0);
        LocalDate dt1 = orderEntityList.get(0).getCreateDate();
        LocalDate dt2= deliveryObj.getDeliveryDate();
        long diffDays = ChronoUnit.DAYS.between(dt1, dt2);
        long maxDiffDays = diffDays;
        Delivery pireDelivery = deliveryObj;

        for(OrderEntity orderEntity: orderEntityRepository.findAll()){
            for(Delivery delivery: orderEntity.getDeliveries()){
                dt1 = orderEntity.getCreateDate();
                dt2 = delivery.getDeliveryDate();
                diffDays = ChronoUnit.DAYS.between(dt1, dt2);
                if(diffDays > maxDiffDays){
                    maxDiffDays = diffDays;
                    pireDelivery = delivery;
                }
            }
        }
        return pireDelivery.getDeliveryMan();
    }
}
