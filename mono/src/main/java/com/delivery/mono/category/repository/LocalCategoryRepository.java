package com.delivery.mono.category.repository;

import com.delivery.mono.category.domain.LocalCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LocalCategoryRepository extends JpaRepository<LocalCategory, UUID> {
    List<LocalCategory> findByIsDeletedFalse();
}
