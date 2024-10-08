package com.delivery.mono.category.domain;

import com.delivery.mono.core.audit.AuditingEntity;
import com.delivery.mono.store.domain.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Table(name = "p_local_category")
public class LocalCategory extends AuditingEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    /* -------------- Mapping -------------- */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "store")
    private List<Store> storeList = new ArrayList<>();

    /* -------------- Constructor -------------- */
    @Builder
    public LocalCategory(String name) {
        this.name = name;
    }

    /* -------------- Methods -------------- */
    public void delete() {
        this.setIsDeleted(true);
    }
}
