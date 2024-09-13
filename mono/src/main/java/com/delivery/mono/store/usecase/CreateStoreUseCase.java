package com.delivery.mono.store.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.store.dto.CreateStoreRequestDto;
import com.delivery.mono.store.dto.StoreUUIDResponseDto;

import java.util.UUID;

@UseCase(value = "createStoreUseCase")
public interface CreateStoreUseCase {
    StoreUUIDResponseDto createStore(CreateStoreRequestDto createStoreRequestDto, UUID userId);
    StoreUUIDResponseDto acceptStore(UUID storeId);
}
