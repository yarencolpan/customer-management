package com.yaren.customer_management.service;

//burası mutfak gibi çalışır yani istek burada işlenir
//veriTabanı kullanışmağında buradan veri oluşturup çekiyoruz

import com.yaren.customer_management.model.Customer;
import com.yaren.customer_management.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerService {


private final CustomerRepository customerRepository;


    //CREATE CUSTOMER
    public Customer createCustomer(Customer customer){

        return customerRepository.save(customer);
    }


    //READ ALL CUSTOMERS
    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();
    }



    //ID'ye GÖRE TEK MÜŞTERİ
    public Customer getCustomerById(long id){
        return customerRepository.findById(id).orElse(null);
    }



    //UPDATE
    public Customer updateCustomer(long id, Customer updated){
        Customer existing = getCustomerById(id);
        if(existing== null){
            return null;
        }
        existing.setName(updated.getName());
        existing.setE_mail(updated.getE_mail());
        existing.setPhone(updated.getPhone());
        existing.setAdress(updated.getAdress());

        return customerRepository.save(existing);
    }



    //DELETE CUSTOMER
    public void deleteCustomer(long id){
        customerRepository.deleteById(id);


            }
        }



