package com.delivery.mono.payment.application.dto;

import com.delivery.mono.payment.domain.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentListDTO {

    private UUID paymentId;
    private UUID orderId;
    private UUID userId;

    // Entity -> PaymentListDTO
    public static PaymentListDTO toDTO(Payment payment){
        return PaymentListDTO.builder()
                .paymentId(payment.getId())
                .orderId(payment.getOrder().getId())
                .userId(payment.getUser().getId())
                .build();
    }
}
