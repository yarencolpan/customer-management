package com.yaren.customer_management.repository;

import com.yaren.customer_management.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface OfferRepository extends JpaRepository<Offer, Long>{
    }

