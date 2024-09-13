package com.delivery.mono.payment.domain.repository;

import com.delivery.mono.payment.application.dto.PaymentListDTO;
import com.delivery.mono.payment.domain.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

     Page<Payment> findAllByUserId(UUID userId, Pageable pageable);
}
