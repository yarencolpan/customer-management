package com.yaren.customer_management.service;

import com.yaren.customer_management.model.OfferItem;
import com.yaren.customer_management.model.Product;
import com.yaren.customer_management.repository.OfferItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OfferItemService {

    private final OfferItemRepository offerItemRepository;
    private final ProductService productService;

    public OfferItem createOfferItem(OfferItem item){
        if(item.getUnitPrice() == null){
            Product product= productService.getById(item.getProductId());
            item.setUnitPrice(product.getUnitPrice());
        }
        return offerItemRepository.save(item);
    }

    public List<OfferItem> getAllOfferItems() {
        return offerItemRepository.findAll();
    }
    public OfferItem getOfferItemById(Long id) {
        return offerItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OfferItem not found. id=" + id));
    }

    public List<OfferItem> getItemsByOfferId(Long offerId) {
        return offerItemRepository.findByOfferId(offerId);
    }

    public OfferItem updateOfferItem(Long id, OfferItem updated) {
        OfferItem existing = getOfferItemById(id);

        existing.setOfferId(updated.getOfferId());
        existing.setProductId(updated.getProductId());
        existing.setQuantity(updated.getQuantity());
        existing.setUnitPrice(updated.getUnitPrice());

        return offerItemRepository.save(existing);
    }

    public void deleteOfferItem(Long id) {
        offerItemRepository.deleteById(id);
    }
}
