package com.delivery.mono.category.service;

import com.delivery.mono.category.domain.LocalCategory;
import com.delivery.mono.category.domain.StoreCategory;
import com.delivery.mono.category.domain.type.CategoryType;
import com.delivery.mono.category.dto.CategoryResponseDto;
import com.delivery.mono.category.dto.CreateCategoryRequestDto;
import com.delivery.mono.category.repository.LocalCategoryRepository;
import com.delivery.mono.category.repository.StoreCategoryRepository;
import com.delivery.mono.category.usecase.CreateCategoryUseCase;
import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCategoryServiceImplV1 implements CreateCategoryUseCase {
    private final StoreCategoryRepository storeCategoryRepository;
    private final LocalCategoryRepository localCategoryRepository;

    @Override
    @Transactional
    public CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        String type = createCategoryRequestDto.type();
        CategoryResponseDto categoryResponseDto;
        if (type.equalsIgnoreCase(CategoryType.STORE.getCategoryType())) {
            categoryResponseDto = createStoreCategory(createCategoryRequestDto);
        } else if (type.equalsIgnoreCase(CategoryType.LOCAL.getCategoryType())) {
            categoryResponseDto = createLocalCategory(createCategoryRequestDto);
        } else {
            throw new BusinessLogicException(ExceptionCode.INVALID_CATEGORY_TYPE);
        }
        return categoryResponseDto;
    }

    private CategoryResponseDto createStoreCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        StoreCategory storeCategory = StoreCategory.builder()
                .name(createCategoryRequestDto.name())
                .build();
        storeCategoryRepository.save(storeCategory);
        return CategoryResponseDto.fromEntity(storeCategory);
    }

    private CategoryResponseDto createLocalCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        LocalCategory localCategory = LocalCategory.builder()
                .name(createCategoryRequestDto.name())
                .build();
        localCategoryRepository.save(localCategory);
        return CategoryResponseDto.fromEntity(localCategory);
    }
}
