package com.sentryc.ttpl.service;

import com.sentryc.ttpl.dto.PageInput;
import com.sentryc.ttpl.dto.SellerFilter;
import com.sentryc.ttpl.dto.SellerPageableResponse;
import com.sentryc.ttpl.dto.enums.SellerSortBy;

public interface SellerInformationService {
    SellerPageableResponse getSellerInfosByFilter(SellerFilter filter, PageInput page, SellerSortBy sortBy);
}
