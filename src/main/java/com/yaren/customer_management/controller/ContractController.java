package com.yaren.customer_management.controller;

import com.yaren.customer_management.model.Contract;
import com.yaren.customer_management.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public List<Contract> getAllContracts(){
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id){
        return contractService.getContractById(id);
    }

    @PostMapping("/{id}sign")
    public Contract signContract(@PathVariable Long id){
        return contractService.signContract(id);
    }
}
