package com.delivery.mono.store.dto;

import com.delivery.mono.store.domain.Store;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record StoreSummaryResponseDto(
        UUID storeId,
        String name,
        List<String> categories, // 카테고리 이름
        Double averageRate // 평균 평점
) {
    public static StoreSummaryResponseDto fromEntity(Store store) {
        return StoreSummaryResponseDto.builder()
                .storeId(store.getId())
                .name(store.getName())
                .categories(store.getStoreCategoryMappers().stream()
                        .map(storeCategoryMapper -> storeCategoryMapper.getStoreCategory().getName())
                        .toList())
                .build();
    }
}
