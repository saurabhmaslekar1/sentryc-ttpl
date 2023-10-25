package com.sentryc.ttpl.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerPageableResponse {

    private PageMeta meta;

    private List<SellerInfoResponse> data;
}
