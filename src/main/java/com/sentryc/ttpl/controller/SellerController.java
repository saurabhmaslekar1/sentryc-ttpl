package com.sentryc.ttpl.controller;

import com.sentryc.ttpl.dto.PageInput;
import com.sentryc.ttpl.dto.SellerFilter;
import com.sentryc.ttpl.dto.enums.SellerSortBy;
import com.sentryc.ttpl.dto.SellerPageableResponse;
import com.sentryc.ttpl.service.SellerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SellerController {

    @Autowired
    private SellerInformationService sellerInformationService;

    @QueryMapping("sellers")
    public SellerPageableResponse getSellerInfosByFilter(@Argument SellerFilter filter, @Argument PageInput page, @Argument SellerSortBy sortBy) {
        return sellerInformationService.getSellerInfosByFilter(filter, page, sortBy);
    }
}
