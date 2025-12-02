package com.yaren.customer_management.config;

import com.yaren.customer_management.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//“Spring, bu sınıftan bir tane nesne oluştur, projede ihtiyaç duyulduğunda kullan.”
public class CustomerList {

    public List<Customer> customers = new ArrayList<>();
    //müşterilerin tutulduğu yer
    //list bir interfacetir oluşturulamaz.Arraylist somut sınıfıdır

    public CustomerList(){

        customers.add(new Customer(1,"Yaren Colpan","yaren@gmail.com","5304760288","Istanbul"));
        customers.add(new Customer(2,"Bekir Tokac","bekirgmail.com","5395558972","Ankara" ));

    }
    public List<Customer>getCustomers(){
        return customers;
    }
}
