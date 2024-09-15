package com.delivery.mono.store.usecase;

import com.delivery.mono.core.annotation.UseCase;

import java.util.UUID;

@UseCase(value = "deleteStoreUseCase")
public interface DeleteStoreUseCase {
    void deleteStoreByAdmin(UUID storeId);
    void deleteStoreByOwner(UUID userId);
}
