package com.sentryc.ttpl.controller;

import com.sentryc.ttpl.dto.PageInput;
import com.sentryc.ttpl.dto.SellerFilter;
import com.sentryc.ttpl.dto.SellerPageableResponse;
import com.sentryc.ttpl.dto.enums.SellerSortBy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class SellerEntityInfoControllerIntegrationTest {

    @Autowired
    private SellerController sellerController;

    @Test
    public void TestGetSellerInfosByFilter() {
        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setSearchByName("Amazon US");
        sellerFilter.setProducerIds(List.of(UUID.fromString("64eb76cb-2b62-4891-b59e-50694a48f376")));
        sellerFilter.setMarketplaceIds(List.of("amazon.ae"));

        PageInput pageInput = new PageInput();
        pageInput.setPage(0);
        pageInput.setSize(10);

        SellerPageableResponse sellerPageableResponse = sellerController.getSellerInfosByFilter(sellerFilter, pageInput, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC);
        assertEquals(sellerPageableResponse.getData().get(0).getExternalId(), "A2QUTRSO1ZHRN9");
    }
}
