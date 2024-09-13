package com.delivery.mono.delivery.dto;

import com.delivery.mono.delivery.domain.Delivery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponseDto {

    private UUID id;
    private String address;
    private String recipientName;
    private boolean isDefault;
    private boolean isDeleted;

    public DeliveryResponseDto(Delivery delivery) {
        this.id = delivery.getId();
        this.address = delivery.getAddress();
        this.recipientName = delivery.getRecipientName();
        this.isDefault = delivery.isDefault();
        this.isDeleted = delivery.getIsDeleted();
    }
}
