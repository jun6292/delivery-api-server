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
public class OrderListDTO {

    private UUID orderId;
    private String storeName;
    private OrderStatusEnum status;
    private boolean isOnline;

    public static OrderListDTO toListDTO(Order order){

        return OrderListDTO.builder()
                .orderId(order.getId())
                .storeName(order.getStore().getName())
                .status(order.getStatus())
                .isOnline(order.isOnline())
                .build();
    }
}
