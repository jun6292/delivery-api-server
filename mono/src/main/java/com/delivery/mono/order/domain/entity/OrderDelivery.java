package com.delivery.mono.order.domain.entity;

import com.delivery.mono.delivery.domain.Delivery;
import com.delivery.mono.core.audit.AuditingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "p_order_delivery")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDelivery extends AuditingEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @PrePersist
    protected void createUUID(){
        if(id == null) id = UUID.randomUUID();
    }
}
