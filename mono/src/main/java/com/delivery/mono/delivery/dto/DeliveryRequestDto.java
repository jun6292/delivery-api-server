package com.delivery.mono.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequestDto {

    private String address;
    private String recipientName;
    private boolean isDefault;
    private boolean isDeleted;

}
