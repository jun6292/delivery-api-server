package com.delivery.mono.category.service;

import com.delivery.mono.category.domain.LocalCategory;
import com.delivery.mono.category.domain.StoreCategory;
import com.delivery.mono.category.dto.CategoryResponseDto;
import com.delivery.mono.category.repository.LocalCategoryRepository;
import com.delivery.mono.category.repository.StoreCategoryRepository;
import com.delivery.mono.category.usecase.ReadAllCategoriesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadAllCategoriesServiceImplV1 implements ReadAllCategoriesUseCase {
    private final StoreCategoryRepository storeCategoryRepository;
    private final LocalCategoryRepository localCategoryRepository;

    @Override
    public List<CategoryResponseDto> readAllStoreCategories() {
        List<StoreCategory> storeCategoryList = storeCategoryRepository.findByIsDeletedFalse();
        List<CategoryResponseDto> categoryResponseDtoList = storeCategoryList.stream()
                .map(storeCategory -> CategoryResponseDto.fromEntity(storeCategory))
                .toList();
        return categoryResponseDtoList;
    }

    @Override
    public List<CategoryResponseDto> readAllLocalCategories() {
        List<LocalCategory> localCategoryList = localCategoryRepository.findByIsDeletedFalse();
        List<CategoryResponseDto> categoryResponseDtoList = localCategoryList.stream()
                .map(localCategory -> CategoryResponseDto.fromEntity(localCategory))
                .toList();
        return categoryResponseDtoList;
    }
}


