package com.pricing.controllers;

import com.pricing.services.PricingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pricing")
public class PricingController {

    private final PricingService pricingService;

    PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping
    public int getPrice() {
        int price = pricingService.getPriceForTrack();

        return price;
    }
}
