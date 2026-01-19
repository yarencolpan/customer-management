package com.yaren.customer_management.service;

import com.yaren.customer_management.model.Offer;
import com.yaren.customer_management.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServise {
    private final OfferRepository offerRepository;

    public Offer createOffer(Offer offer) {
        // isApproved null gelirse false yapalım (basit koruma)
        if (offer.getIsApproved() == null) {
            offer.setIsApproved(false);
        }
        return offerRepository.save(offer);
    }
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
    public Offer getOfferById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found. id=" + id));
    }

    public Offer updateOffer(Long id, Offer updated) {
        Offer existing = getOfferById(id);

        existing.setCustomerId(updated.getCustomerId());

        // Onay durumunu şimdilik update ile değiştirmeyelim
        // (approve endpoint ayrı olacak)
        return offerRepository.save(existing);
    }
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}
