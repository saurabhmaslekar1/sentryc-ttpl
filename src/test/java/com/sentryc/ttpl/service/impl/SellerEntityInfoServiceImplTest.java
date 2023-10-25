package com.sentryc.ttpl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.ttpl.dto.PageMeta;
import com.sentryc.ttpl.dto.PageInput;
import com.sentryc.ttpl.dto.SellerFilter;
import com.sentryc.ttpl.dto.SellerPageableResponse;
import com.sentryc.ttpl.dto.enums.SellerSortBy;
import com.sentryc.ttpl.dao.SellerRepository;
import com.sentryc.ttpl.domain.SellerEntity;
import com.sentryc.ttpl.dao.SellerInfoRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerInformationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SellerEntityInfoServiceImplTest {
    @MockBean
    private SellerInfoRepository sellerInfoRepository;

    @Autowired
    private SellerInformationServiceImpl sellerInfoServiceImpl;

    @MockBean
    private SellerRepository sellerRepository;

    /**
     * Method under test: {@link SellerInformationServiceImpl#getSellerInfosByFilter(SellerFilter, PageInput, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter() {
        when(sellerRepository.findAll(Mockito.<Specification<SellerEntity>>any())).thenReturn(new ArrayList<>());

        SellerFilter filter = new SellerFilter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageInput page = mock(PageInput.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponse actualSellerInfosByFilter = sellerInfoServiceImpl.getSellerInfosByFilter(filter, page,
                SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC);
        assertTrue(actualSellerInfosByFilter.getData().isEmpty());
        PageMeta meta = actualSellerInfosByFilter.getMeta();
        assertEquals(0, meta.getPage());
        assertEquals(0, meta.getTotalRecords());
        assertEquals(3, meta.getSize());
        verify(sellerRepository).findAll(Mockito.<Specification<SellerEntity>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }
}

