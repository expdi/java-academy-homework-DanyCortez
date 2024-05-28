package com.track.musictrack.provider;

import com.track.musictrack.classes.Track;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Component
public class NetworkPriceProvider implements INetworkingPriceProvider {

    private RestClient restClient;

    private String ratingUrl;
    public NetworkPriceProvider() {
        var baseUrl = "http://localhost:10001";
        var rootUrl = "/pricing";
        ratingUrl = rootUrl;

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @Override
    public void addPriceToTrack(Track track) {
         int price = 0;

         if(track != null) {
             ResponseEntity<Integer> result =  restClient.get()
                     .uri(ratingUrl, 1)
                     .retrieve()
                     .toEntity(Integer.class);

             price = result.getBody().intValue();
         }

        track.setPrice(price);
    }
}
