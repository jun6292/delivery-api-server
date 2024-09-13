package com.delivery.mono.order.application.service;

import com.delivery.mono.order.application.dto.OrderListDTO;
import com.delivery.mono.order.application.dto.OrderRequestDTO;
import com.delivery.mono.order.application.dto.OrderResponseDTO;
import com.delivery.mono.order.application.dto.OrderUpdateStatusDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {

    // getList
    Page<OrderListDTO> getOrderByUserId(UUID userId, int page, int size, String sortBy, boolean desc);

    // Create Order
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    // FindOrderById
    OrderResponseDTO findOrderById(UUID orderId);

    // Update Order Status
    OrderUpdateStatusDTO updateOrderStatus(OrderUpdateStatusDTO orderUpdateStatusDTO);

    // Cancel Order
    void cancelOrder(UUID orderId);
}
