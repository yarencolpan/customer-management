package com.yaren.customer_management.controller;

import com.yaren.customer_management.model.Offer;
import com.yaren.customer_management.service.OfferServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferServise offerServise;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerServise.getAllOffers();
}

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable Long id) {
        return offerServise.getOfferById(id);
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerServise.createOffer(offer);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer updated) {
        return offerServise.updateOffer(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        offerServise.deleteOffer(id);
    }}