package com.sentryc.ttpl.dao;

import com.sentryc.ttpl.domain.SellerEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, UUID> {
    List<SellerEntity> findAll(Specification<SellerEntity> specification);
}
