package com.delivery.mono.store.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.store.dto.StoreDetailResponseDto;
import com.delivery.mono.store.dto.UpdateStoreRequestDto;

import java.util.UUID;

@UseCase(value = "updateStoreUseCase")
public interface UpdateStoreUseCase {
    StoreDetailResponseDto updateStoreByAdmin(UUID storeId, UpdateStoreRequestDto updateStoreRequestDto);
    StoreDetailResponseDto updateStoreByOwner(UUID userId, UpdateStoreRequestDto updateStoreRequestDto);
}
