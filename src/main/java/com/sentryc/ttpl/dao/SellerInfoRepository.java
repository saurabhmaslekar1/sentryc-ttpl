package com.sentryc.ttpl.dao;

import com.sentryc.ttpl.domain.SellerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfoEntity, UUID> {
}
