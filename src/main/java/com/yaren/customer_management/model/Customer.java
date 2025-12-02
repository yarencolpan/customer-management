package com.yaren.customer_management.model;

//verinin sekli

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    private int id;
    private String name;
    private String eMail;
    private String phone;
    private String adress;
}
