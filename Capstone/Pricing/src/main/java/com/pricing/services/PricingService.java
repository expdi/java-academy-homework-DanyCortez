package com.pricing.services;

import com.pricing.interfaces.IPricingService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PricingService implements IPricingService {
    int lowerLimitForPrice = 1;
    int higestLimitForPrice = 10;

    public int getPriceForTrack() {
        return ThreadLocalRandom.current().nextInt(lowerLimitForPrice, higestLimitForPrice);
    }

}
