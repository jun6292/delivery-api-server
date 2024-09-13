package com.delivery.mono.order.application.dto;

import com.delivery.mono.order.domain.entity.Order;
import com.delivery.mono.order.domain.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderUpdateStatusDTO {

    private UUID orderId;
    private OrderStatusEnum status;

    public static OrderUpdateStatusDTO toStatusDTO(Order order){
        return OrderUpdateStatusDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }
}
