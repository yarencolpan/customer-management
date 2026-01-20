package com.yaren.customer_management.controller;

import com.yaren.customer_management.model.Offer;
import com.yaren.customer_management.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
}

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.createOffer(offer);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer updated) {
        return offerService.updateOffer(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
    }

    @PostMapping("/{id}/approve")
    public Offer approveOffer(@PathVariable Long id){
        return offerService.approveOffer(id);
    }


}