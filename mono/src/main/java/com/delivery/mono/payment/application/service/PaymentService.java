package com.delivery.mono.payment.application.service;

import com.delivery.mono.payment.application.dto.PaymentListDTO;
import com.delivery.mono.payment.application.dto.PaymentRequestDTO;
import com.delivery.mono.payment.application.dto.PaymentResponseDTO;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PaymentService {

    // findAllByUserId - getPaymentList
    Page<PaymentListDTO> getPaymentList(UUID userId, int page, int size, String sortBy, boolean orderBy);

    // Create Payment
    PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO);

    // findByPaymentId
    PaymentResponseDTO findByPaymentId(UUID paymentId);
}
