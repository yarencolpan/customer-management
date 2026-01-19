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
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long customerId;
    private Boolean isApproved = false;

    // ---- Audit alanları (şimdilik sadece tanım) ----
    private Long createdById;
    private LocalDateTime createdDate;
    private Long lastModifiedById;
    private LocalDateTime lastModifiedDate;
    private Long deletedById;
}
