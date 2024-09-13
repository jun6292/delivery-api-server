package com.delivery.mono.store.dto;

import com.delivery.mono.store.domain.Store;
import lombok.Builder;

import java.util.UUID;


@Builder
public record StoreUUIDResponseDto(
        UUID storeId
) {
    public static StoreUUIDResponseDto fromEntity(Store storeEntity) {
        return StoreUUIDResponseDto.builder()
                .storeId(storeEntity.getId())
                .build();
    }
}
