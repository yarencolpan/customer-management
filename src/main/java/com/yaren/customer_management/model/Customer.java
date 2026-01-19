package com.yaren.customer_management.model;

//verinin sekli

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String name;

    private String e_mail;

    private String phone;

    private String adress;

    private Long createdById;    //bu kaydı oluşturan kullanıcının ID'si

    private LocalDateTime createdDate;    //kayıdın ilk kez oluşturulduğu tarih

    private long lastModifiedById;    //kaydı en son güncelleyen kullanıcının ID'si

    private LocalDateTime lastModifiedByDate;     //kayıt en son ne zaman güncellendi

    private Long deletedById;    //kaydı silen kullanıcının ıd si







}
