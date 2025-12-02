package com.yaren.customer_management.service;

//burası mutfak gibi çalışır yani istek burada işlenir
//veriTabanı kullanışmağında buradan veri oluşturup çekiyoruz

import com.yaren.customer_management.config.CustomerList;
import com.yaren.customer_management.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerList customerList;
    //bu sınıf CustomerList istiyor Bende CustomerList bean’i var.O zaman constructor’a vereyim.”
    //final = “Bu değişken sabit olsun.”



    //CREATE CUSTOMER
    public Customer createCustomer(Customer customer){
        customerList.getCustomers().add(customer);
        return customer;
    }



    //READ ALL CUSTOMERS
    public List<Customer> getAllCustomers(){

        return customerList.getCustomers();
    }



    //ID'ye GÖRE TEK MÜŞTERİ
    public Customer getCustomerById(int id){
        for (Customer customer: customerList.getCustomers()){
            if(customer.getId()== id){
                return customer;
            }
        }
        return null;
    }



    //UPDATE
    public Customer updateCustomer(int id, Customer updated){
        Customer existing = getCustomerById(id);
        if(existing== null){
            return null;
        }
        existing.setName(updated.getName());
        existing.setEMail(updated.getEMail());
        existing.setPhone(updated.getPhone());
        existing.setAdress(updated.getAdress());

        return existing;
    }



    //DELETE CUSTOMER
    public void deleteCustomer(int id){
        List<Customer> list = customerList.getCustomers();

        for (int i = 0; i < list.size(); i++){
            if ((list.get(i).getId() == id)){
                list.remove((i));
                return;

            }
        }
    }

}
