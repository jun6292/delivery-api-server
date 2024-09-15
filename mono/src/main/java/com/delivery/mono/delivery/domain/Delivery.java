package com.delivery.mono.delivery.domain;

import com.delivery.mono.delivery.dto.DeliveryRequestDto;
import com.delivery.mono.core.audit.AuditingEntity;
import com.delivery.mono.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "p_delivery")
public class Delivery extends AuditingEntity {

    @Id
    private UUID id;
    private String address;
    private String recipientName;
    private boolean isDefault;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    //UUID 자동생성
    @PrePersist
    protected void createUUID(){
        if(id == null) id = UUID.randomUUID();
    }

    public Delivery(DeliveryRequestDto deliveryRequestDto) {
        this.address = deliveryRequestDto.getAddress();
        this.recipientName = deliveryRequestDto.getRecipientName();
        this.isDefault = deliveryRequestDto.isDefault();
    }


    public void update(DeliveryRequestDto deliveryRequestDto) {
        this.address = deliveryRequestDto.getAddress();
        this.recipientName = deliveryRequestDto.getRecipientName();
        this.isDefault = deliveryRequestDto.isDefault();
    }

    public void saveDefaultAddress() {
        this.isDefault = true;
    }

    public void checkUser(User user) {
        if (!user.equals(user)) {
            throw new IllegalArgumentException("잘못된 배송 아이디 입니다.");
        }
    }
}
