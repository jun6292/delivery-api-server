package com.delivery.mono.store.usecase;

import com.delivery.mono.core.annotation.UseCase;
import com.delivery.mono.store.dto.StoreDetailResponseDto;

import java.util.UUID;

@UseCase(value = "readStoreDetailUseCase")
public interface ReadStoreDetailUseCase {
    StoreDetailResponseDto readStoreDetail(UUID storeId);
}
