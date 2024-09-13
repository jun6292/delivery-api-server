package com.delivery.mono.order.domain.repository;

import com.delivery.mono.order.domain.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

   Page<Order> findAllByUserId(UUID userId, Pageable pageable);
}
