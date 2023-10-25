package com.sentryc.ttpl.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.ttpl.dto.PageMeta;
import com.sentryc.ttpl.dto.PageInput;
import com.sentryc.ttpl.dto.SellerFilter;
import com.sentryc.ttpl.dto.SellerPageableResponse;
import com.sentryc.ttpl.dto.enums.SellerSortBy;
import com.sentryc.ttpl.service.SellerInformationService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerController.class})
@ExtendWith(SpringExtension.class)
class SellerEntityInfoControllerTest {
    @Autowired
    private SellerController sellerController;

    @MockBean
    private SellerInformationService sellerInformationService;

    /**
     * Method under test: {@link SellerController#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new PageMeta(1, 3, 1));
        when(sellerInformationService.getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInput page = new PageInput();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInfosByFilter(filter, page, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC));
        verify(sellerInformationService).getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter2() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new PageMeta(1, 3, 1));
        when(sellerInformationService.getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInput page = new PageInput();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInfosByFilter(filter, page, SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC));
        verify(sellerInformationService).getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter3() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new PageMeta(1, 3, 1));
        when(sellerInformationService.getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInput page = new PageInput();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInfosByFilter(filter, page, SellerSortBy.NAME_ASC));
        verify(sellerInformationService).getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter4() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new PageMeta(1, 3, 1));
        when(sellerInformationService.getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInput page = new PageInput();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInfosByFilter(filter, page, SellerSortBy.NAME_DESC));
        verify(sellerInformationService).getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter5() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new PageMeta(1, 3, 1));
        when(sellerInformationService.getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInput page = new PageInput();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInfosByFilter(filter, page, SellerSortBy.MARKETPLACE_ID_ASC));
        verify(sellerInformationService).getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter6() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new PageMeta(1, 3, 1));
        when(sellerInformationService.getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInput page = new PageInput();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInfosByFilter(filter, page, SellerSortBy.MARKETPLACE_ID_DESC));
        verify(sellerInformationService).getSellerInfosByFilter(Mockito.<SellerFilter>any(), Mockito.<PageInput>any(),
                Mockito.<SellerSortBy>any());
    }
}

