package com.delivery.mono.delivery.repository;

import com.delivery.mono.delivery.domain.Delivery;
import com.delivery.mono.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
    boolean existsByAddress(String address);

    Optional<Delivery> findByUser(User user);

    List<Delivery> findAllByUser(User user);

    Page<Delivery> findAllByUser(User user, Pageable pageable);

    Delivery findByUserIdAndIsDefault(UUID userId, boolean isDefault);
}
