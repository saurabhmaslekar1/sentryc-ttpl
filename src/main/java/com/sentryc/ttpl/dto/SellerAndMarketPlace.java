package com.sentryc.ttpl.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class SellerAndMarketPlace {
    String name;
    String externalId;
    String marketPlaceId;

    public SellerAndMarketPlace(String externalId, String marketPlaceId, String name) {
        this.name = name;
        this.externalId = externalId;
        this.marketPlaceId = marketPlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerAndMarketPlace that = (SellerAndMarketPlace) o;
        return Objects.equals(externalId, that.externalId) &&
                Objects.equals(marketPlaceId, that.marketPlaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, marketPlaceId);
    }
}