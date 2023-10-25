package com.sentryc.ttpl.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "seller_infos")
@Data
public class SellerInfoEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "marketplace_id", referencedColumnName = "id")
    private MarketPlaceEntity marketPlaceEntity;

    private String name;
    private String url;
    private String country;

    @Column(name = "external_id")
    private String externalId;
}
