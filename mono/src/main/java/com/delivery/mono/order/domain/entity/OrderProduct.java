package com.delivery.mono.order.domain.entity;

import com.delivery.mono.core.audit.AuditingEntity;
import com.delivery.mono.product.domain.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "p_order_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderProduct extends AuditingEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name="amount", nullable = false)
    private int amount;

    @PrePersist
    protected void createUUID(){
        if(id == null) id = UUID.randomUUID();
    }
}
