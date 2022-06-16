package com.example.customerproject.Services;

import com.example.customerproject.Entities.Customer;
import com.example.customerproject.Entities.Item;
import com.example.customerproject.Entities.OrderDetails;
import com.example.customerproject.Entities.OrderEntity;
import com.example.customerproject.Repositories.CustomerRepository;
import com.example.customerproject.Repositories.ItemRepository;
import com.example.customerproject.Repositories.OrderDetailsRepository;
import lombok.AllArgsConstructor;

import org.aspectj.weaver.ast.And;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private OrderDetailsService orderDetailsService;

    //Afficher  les  5  tops  clients selon  le  nombre  de ces commandes
    public void CustomerPlusCommandes() {
        ArrayList<Customer> customerList = (ArrayList<Customer>) customerRepository.findAll();
        Collections.sort(customerList, Customer.ComparatorOrders); 

        Integer counter = 0;
        for (Customer customer : customerList) {
            if(counter<=4){
                System.out.println(customer.getName());
                counter++;
            } else {
                break;
            }
          }
	}

    // Retourne les dépenses total d'un client donné 
    public float CustomerOrderDepenses(Integer idCustomer) {
        List<Customer> listCustomers = customerRepository.findAll();
        Customer customer = null;
        for (Customer item: listCustomers){
            if(item.getId() == idCustomer){
                customer = item;
            }
        }
        float depenses = 0;
        if(customer != null){
            for(OrderEntity orderEntity: customer.getOrderEntities()){
                depenses = depenses + orderDetailsService.calculateTotal(orderEntity.getId());
            }
        }
        return depenses;
}

    //Afficher  les  5  tops  clients selon le montant d'argent dépensé
    public void CustomerPlusDepenses() {
        ArrayList<Customer> customerList = (ArrayList<Customer>) customerRepository.findAll();
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return (int) (CustomerOrderDepenses(c2.getId()) - CustomerOrderDepenses(c1.getId()));
                }}
            ); 
        Integer counter = 0;
        for (Customer customer : customerList) {
            if(counter<=4){
                System.out.println(customer.getName());
                counter++;
            } else {
                break;
            }
          }

	}

    //Afficher les clients qui ont demandé des ordres dont dépassent le 10 kg dans une période donnée
    public void CustomerOrderPlus10Kg(String dateDebut, String dateFin) {
        for (Customer customer : customerRepository.findAll()) {
            for(OrderEntity orderEntity: customer.getOrderEntities()){
                if(orderEntity.getCreateDate().toEpochDay() >= LocalDate.parse(dateDebut).toEpochDay() &&
                orderEntity.getCreateDate().toEpochDay() <= LocalDate.parse(dateFin).toEpochDay() &&
                orderDetailsService.calculateWeight(orderEntity.getId()) > 10){
                    System.out.println(customer.getName());
                }
            }
          }

	}

   
    
}
