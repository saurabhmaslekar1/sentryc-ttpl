package com.sentryc.ttpl.service.impl;

import com.sentryc.ttpl.dto.*;
import com.sentryc.ttpl.dto.enums.SellerSortBy;
import com.sentryc.ttpl.dao.SellerRepository;
import com.sentryc.ttpl.service.SellerInformationService;
import com.sentryc.ttpl.domain.SellerEntity;
import com.sentryc.ttpl.dao.SellerInfoRepository;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SellerInformationServiceImpl implements SellerInformationService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public SellerPageableResponse getSellerInfosByFilter(SellerFilter filter, PageInput page, SellerSortBy sortBy) {
        Specification<SellerEntity> specification = getSellerSpecification(filter);
        List<SellerEntity> sellerEntityList = sellerRepository.findAll(specification);
        List<SellerInfoResponse> sellerInfoResponseList = new ArrayList<>();
        Map<SellerAndMarketPlace, List<SellerEntity>> sellerInfoListMap = sellerEntityList.stream().collect(Collectors.groupingBy(sellerEntityInfo -> new SellerAndMarketPlace(sellerEntityInfo.getSellerInfoEntity().getExternalId(), sellerEntityInfo.getSellerInfoEntity().getMarketPlaceEntity().getId(), sellerEntityInfo.getSellerInfoEntity().getName())));
        sellerInfoListMap.forEach((sellerAndMarketPlace, sellersList) -> createSellerInfoResponseDTO(sellerAndMarketPlace, sellersList, sellerInfoResponseList));

        sortSellerResponse(sortBy, sellerInfoResponseList);
        PageImpl<SellerInfoResponse> pageable = getSellerResponsePage(page, sellerInfoResponseList);
        SellerPageableResponse sellerPageableResponse = getSellerPageableResponseDTO(page, pageable, sellerInfoResponseList);
        return sellerPageableResponse;
    }

    private SellerPageableResponse getSellerPageableResponseDTO(PageInput page, PageImpl<SellerInfoResponse> pageable, List<SellerInfoResponse> sellerInfoResponseList) {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(pageable.getContent());
        sellerPageableResponse.setMeta(new PageMeta(page.getPage(), page.getSize(), sellerInfoResponseList.size()));
        return sellerPageableResponse;
    }

    private PageImpl<SellerInfoResponse> getSellerResponsePage(PageInput page, List<SellerInfoResponse> sellerInfoResponseList) {
        int start = page.getPage() * page.getSize();
        int end = Math.min(start + page.getSize(), sellerInfoResponseList.size());
        List<SellerInfoResponse> sellerInfoResponseListPageable = sellerInfoResponseList.subList(start, end);
        PageImpl<SellerInfoResponse> pageable =  new PageImpl<>(sellerInfoResponseListPageable, PageRequest.of(page.getPage(), page.getSize()), sellerInfoResponseList.size());
        return pageable;
    }

    private void sortSellerResponse(SellerSortBy sortBy, List<SellerInfoResponse> sellerInfoResponseList) {
        switch (sortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC -> sellerInfoResponseList.sort(Comparator.comparing(SellerInfoResponse::getExternalId));
            case SELLER_INFO_EXTERNAL_ID_DESC -> sellerInfoResponseList.sort(Comparator.comparing(SellerInfoResponse::getExternalId).reversed());
            case NAME_ASC -> sellerInfoResponseList.sort(Comparator.comparing(SellerInfoResponse::getSellerName));
            case NAME_DESC -> sellerInfoResponseList.sort(Comparator.comparing(SellerInfoResponse::getSellerName).reversed());
            case MARKETPLACE_ID_ASC -> sellerInfoResponseList.sort(Comparator.comparing(SellerInfoResponse::getMarketplaceId));
            case MARKETPLACE_ID_DESC -> sellerInfoResponseList.sort(Comparator.comparing(SellerInfoResponse::getMarketplaceId).reversed());
        }
    }

    private void createSellerInfoResponseDTO(SellerAndMarketPlace sellerAndMarketPlace, List<SellerEntity> sellersList, List<SellerInfoResponse> sellerInfoResponseList) {
        SellerInfoResponse sellerInfoResponse = new SellerInfoResponse();
        sellerInfoResponse.setSellerName(sellerAndMarketPlace.getName());
        sellerInfoResponse.setExternalId(sellerAndMarketPlace.getExternalId());
        sellerInfoResponse.setMarketplaceId(sellerAndMarketPlace.getMarketPlaceId());

        List<ProducerSellerState> producerSellerStateList = new ArrayList<>();
        sellersList.forEach(sellerEntity -> {
            createProducerSellerStateDTO(sellerEntity, producerSellerStateList);
        });
        sellerInfoResponse.setProducerSellerStates(producerSellerStateList);
        sellerInfoResponseList.add(sellerInfoResponse);
    }

    private void createProducerSellerStateDTO(SellerEntity sellerEntity, List<ProducerSellerState> producerSellerStateList) {
        ProducerSellerState producerSellerState = new ProducerSellerState();
        producerSellerState.setSellerId(sellerEntity.getSellerInfoEntity().getId().toString());
        producerSellerState.setSellerState(sellerEntity.getState());
        producerSellerState.setProducerName(sellerEntity.getProducerEntity().getName());
        producerSellerState.setProducerId(sellerEntity.getProducerEntity().getId().toString());
        producerSellerStateList.add(producerSellerState);
    }

    private Specification<SellerEntity> getSellerSpecification(SellerFilter filter) {
        Specification<SellerEntity> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(filter.getSearchByName())) {
                predicates.add(criteriaBuilder.like(root.get("sellerInfo").get("name"), "%" + filter.getSearchByName() + "%"));
            }
            if (filter.getProducerIds() != null && !filter.getProducerIds().isEmpty()) {
                predicates.add(root.get("producer").get("id").in(filter.getProducerIds()));
            }
            if (filter.getMarketplaceIds() != null && !filter.getMarketplaceIds().isEmpty()) {
                predicates.add(root.get("sellerInfo").get("marketPlace").get("id").in(filter.getMarketplaceIds()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return specification;
    }
}
