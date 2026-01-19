package com.yaren.customer_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offer_items")
public class OfferItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long offerId;
    private Long productId;
    private Long quantity;
    private Double unitPrice;



    private Long createdById;
    private LocalDateTime createdDate;
    private Long lastModifiedById;
    private LocalDateTime lastModifiedDate;
    private Long deletedById;
}
