package com.sentryc.ttpl.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerInfoResponse {

    private String sellerName;

    private String externalId;

    private String marketplaceId;

    private List<ProducerSellerState> producerSellerStates;
}
