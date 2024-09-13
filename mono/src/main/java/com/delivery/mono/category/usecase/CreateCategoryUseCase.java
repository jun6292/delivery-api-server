package com.delivery.mono.category.usecase;

import com.delivery.mono.category.dto.CategoryResponseDto;
import com.delivery.mono.category.dto.CreateCategoryRequestDto;
import com.delivery.mono.global.annotation.UseCase;

@UseCase(value = "createCategoryUseCase")
public interface CreateCategoryUseCase {
    CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto);
}
