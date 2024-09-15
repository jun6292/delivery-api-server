package com.delivery.mono.category.service;

import com.delivery.mono.category.domain.LocalCategory;
import com.delivery.mono.category.domain.StoreCategory;
import com.delivery.mono.category.repository.LocalCategoryRepository;
import com.delivery.mono.category.repository.StoreCategoryRepository;
import com.delivery.mono.category.usecase.DeleteCategoryUseCase;
import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCategoryServiceImplV1 implements DeleteCategoryUseCase {
    private final StoreCategoryRepository storeCategoryRepository;
    private final LocalCategoryRepository localCategoryRepository;

    @Override
    public void deleteStoreCategory(UUID uuid) {
        StoreCategory storeCategory = storeCategoryRepository.findById(uuid)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.CATEGORY_NOT_FOUND));
        storeCategory.delete();
        // storeCategoryRepository.delete(storeCategory);
    }

    @Override
    public void deleteLocalCategory(UUID uuid) {
        LocalCategory localCategory = localCategoryRepository.findById(uuid)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.CATEGORY_NOT_FOUND));
        localCategory.delete();
        // localCategoryRepository.delete(localCategory);
    }
}
