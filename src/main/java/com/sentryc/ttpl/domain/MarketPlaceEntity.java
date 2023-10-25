package com.sentryc.ttpl.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marketplaces")
@Data
public class MarketPlaceEntity {

    @Id
    private String id;

    private String description;
}
