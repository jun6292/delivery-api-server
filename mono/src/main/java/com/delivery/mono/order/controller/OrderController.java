package com.delivery.mono.order.controller;

import com.delivery.mono.order.application.dto.OrderListDTO;
import com.delivery.mono.order.application.dto.OrderRequestDTO;
import com.delivery.mono.order.application.dto.OrderResponseDTO;
import com.delivery.mono.order.application.dto.OrderUpdateStatusDTO;
import com.delivery.mono.order.application.service.OrderService;
import com.delivery.mono.user.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2(topic = "Order Controller")
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    // GET OrderList
    @GetMapping("")
    public Page<OrderListDTO> getOrderList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "createdAt") String sortBy,
            @RequestParam(value = "desc", defaultValue = "true") boolean orderBy,
            @AuthenticationPrincipal UserPrincipal userPrincipal) {

        log.info("OrderController : GET getOrderList");

        UUID userId = userPrincipal.getId();

        return orderService.getOrderByUserId(userId, page-1, size, sortBy, orderBy);

    }

    // Create Order
    @PostMapping("")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO, @AuthenticationPrincipal UserPrincipal userPrincipal
    ) {

        log.info("OrderController : POST createOrder");

        UUID userId = userPrincipal.getId();
        orderRequestDTO.setUserId(userId);

        OrderResponseDTO dto = orderService.createOrder(orderRequestDTO);

        return ResponseEntity.ok(dto);
    }

    // FindByOrderId
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> findByOrderId(@PathVariable UUID orderId) {

        log.info("OrderController : GET findByOrderId");

        log.info("orderID: " + orderId);

        OrderResponseDTO dto = orderService.findOrderById(orderId);

        return ResponseEntity.ok(dto);

    }

    // Update Order Status
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderUpdateStatusDTO> updateOrderStatus(@PathVariable UUID orderId, @RequestBody OrderUpdateStatusDTO orderUpdateStatusDTO) {

        log.info("OrderController : PUT updateOrderStatus");

        orderUpdateStatusDTO.setOrderId(orderId);
        OrderUpdateStatusDTO dto = orderService.updateOrderStatus(orderUpdateStatusDTO);

        return ResponseEntity.ok(dto);
    }

    // Cancel Order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable UUID orderId) {

        log.info("OrderController : DELETE cancelOrder");

        orderService.cancelOrder(orderId);

        return ResponseEntity.ok("주문이 취소되었습니다.");
    }
}
