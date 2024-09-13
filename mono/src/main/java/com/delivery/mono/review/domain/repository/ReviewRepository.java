package com.delivery.mono.review.domain.repository;

import com.delivery.mono.review.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

    Page<Review> findAllByStoreIdAndIsDeletedFalse(UUID storeId, Pageable pageable);
}
