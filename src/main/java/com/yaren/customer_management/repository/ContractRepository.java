package com.yaren.customer_management.repository;

import com.yaren.customer_management.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findByOfferId(Long offerId);
}
