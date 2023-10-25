package com.sentryc.ttpl.dto;

import com.sentryc.ttpl.dto.enums.SellerState;
import lombok.Data;

@Data
public class ProducerSellerState {

    private String producerId;

    private String producerName;

    private SellerState sellerState;

    private String sellerId;
}
