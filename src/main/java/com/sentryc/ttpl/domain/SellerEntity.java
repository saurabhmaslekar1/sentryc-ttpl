package com.sentryc.ttpl.domain;

import com.sentryc.ttpl.dto.enums.SellerState;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "sellers")
@Data
public class SellerEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "seller_info_id", referencedColumnName = "id")
    private SellerInfoEntity sellerInfoEntity;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private ProducerEntity producerEntity;

    @Enumerated(EnumType.STRING)
    private SellerState state;

}
