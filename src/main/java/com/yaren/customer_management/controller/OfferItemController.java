package com.yaren.customer_management.controller;

import com.yaren.customer_management.model.OfferItem;
import com.yaren.customer_management.service.OfferItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offer-items")
public class OfferItemController {

    private final OfferItemService offerItemService;

    @PostMapping
    public OfferItem createOfferItem(@RequestBody OfferItem item) {
        return offerItemService.createOfferItem(item);
    }

    @GetMapping
    public List<OfferItem> getAllOfferItems() {
        return offerItemService.getAllOfferItems();
    }

    @GetMapping("/{id}")
    public OfferItem getOfferItemById(@PathVariable Long id) {
        return offerItemService.getOfferItemById(id);
    }

    @GetMapping("/by-offer/{offerId}")
    public List<OfferItem> getItemsByOfferId(@PathVariable Long offerId){
        return offerItemService.getItemsByOfferId(offerId);
    }

    @PutMapping("/{id}")
    public OfferItem updateOfferItem(@PathVariable Long id, @RequestBody OfferItem updated){
        return offerItemService.updateOfferItem(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferItem(@PathVariable Long id) {
        offerItemService.deleteOfferItem(id);
    }

}
