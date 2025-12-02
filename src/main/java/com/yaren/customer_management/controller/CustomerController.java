package com.yaren.customer_management.controller;

import com.yaren.customer_management.model.Customer;
import com.yaren.customer_management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Bu katman Browser'dan Postman'den Frontend'den gelen istekleri karşılayan yerdir.
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers") //URL kök yolu
public class CustomerController {

    private final CustomerService customerService;
    //Bu yöntem (“final + @RequiredArgsConstructor ile constructor injection”)
    //controller → service → repository
    //zincirini birbirine bağlamak için kullanılan en doğru yöntemdir.

    //Get işlemleri
    @GetMapping
    public List<Customer> gelAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id){
 //@PathVariable URL’nin içindeki değişkeni metot parametresine bağlar
        return customerService.getCustomerById(id);
    }



    //post işlemi
    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer){
 //@RequestBody JSON gövdesindeki veriyi almak için kullanılır
        return customerService.createCustomer(customer);
    }



    //Update işlemi

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer updated){
        return customerService.updateCustomer(id, updated);

    }


    //Delete islemi
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }
}

