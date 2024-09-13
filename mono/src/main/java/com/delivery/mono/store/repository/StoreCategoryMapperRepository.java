package com.delivery.mono.store.repository;

import com.delivery.mono.category.domain.StoreCategoryMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreCategoryMapperRepository extends JpaRepository<StoreCategoryMapper, UUID> {
}
