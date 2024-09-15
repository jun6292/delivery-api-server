package com.delivery.mono.category.usecase;

import com.delivery.mono.core.annotation.UseCase;

import java.util.UUID;

@UseCase(value = "deleteCategoryUseCase")
public interface DeleteCategoryUseCase {
    void deleteStoreCategory(UUID uuid);
    void deleteLocalCategory(UUID uuid);
}
