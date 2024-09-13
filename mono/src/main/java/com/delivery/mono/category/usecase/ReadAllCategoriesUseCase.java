package com.delivery.mono.category.usecase;

import com.delivery.mono.category.dto.CategoryResponseDto;
import com.delivery.mono.global.annotation.UseCase;

import java.util.List;

@UseCase(value = "readAllCategoriesUseCase")
public interface ReadAllCategoriesUseCase {
    List<CategoryResponseDto> readAllStoreCategories();
    List<CategoryResponseDto> readAllLocalCategories();
}
