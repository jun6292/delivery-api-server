package com.delivery.mono.payment.domain.entity;

import com.delivery.mono.global.audit.AuditingEntity;
import com.delivery.mono.order.domain.entity.Order;
import com.delivery.mono.payment.domain.enums.PaymentMethodEnum;
import com.delivery.mono.payment.domain.enums.PaymentStatusEnum;
import com.delivery.mono.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "p_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends AuditingEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total_price", nullable = false)
    private int totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethodEnum paymentMethod;

    @PrePersist
    protected void createUUID(){
        if(id == null) id = UUID.randomUUID();
    }
}
