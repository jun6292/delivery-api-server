package com.delivery.mono.product.domain;

import com.delivery.mono.core.audit.AuditingEntity;
import com.delivery.mono.product.dto.ProductRequestDto;
import com.delivery.mono.store.domain.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends AuditingEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private boolean isHidden = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @PrePersist
    protected void createUUID(){
        if(id == null) id = UUID.randomUUID();
    }

    public Product(ProductRequestDto productRequestDto, Store store) {
        this.name = productRequestDto.getName();
        this.description = productRequestDto.getDescription();
        this.price = productRequestDto.getPrice();
        this.store = store;
        this.isHidden = productRequestDto.isHidden();
    }

    public void update(ProductRequestDto productRequestDto) {
        this.name = productRequestDto.getName();
        this.description = productRequestDto.getDescription();
        this.price = productRequestDto.getPrice();
        this.isHidden = productRequestDto.isHidden();

    }
}
