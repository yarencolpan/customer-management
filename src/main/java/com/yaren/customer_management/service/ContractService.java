package com.yaren.customer_management.service;

import com.yaren.customer_management.model.Contract;
import com.yaren.customer_management.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;

    public Contract createContractForOffer(Long offerId){
        //aynı offerıd için sözleşme varsa tekrar oluşturma
        contractRepository.findByOfferId(offerId)
                .ifPresent(c -> {
            throw new RuntimeException(
                    "Contract already exists for offerId=" + offerId
            );
        });

    //yoksa yeni sözleşme oluştur
        Contract contract = new Contract();
        contract.setOfferId(offerId);
        contract.setIsSigned(false);

        return contractRepository.save(contract);
    }

    public Contract signContract(Long contractId){
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new RuntimeException("Contract not found. id=" + contractId));

        contract.setIsSigned(true);
        return contractRepository.save(contract);

    }

    public List<Contract> getAllContracts(){
        return contractRepository.findAll();
    }

    public  Contract getContractById(Long id){
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found. id=" + id));

    }
}
