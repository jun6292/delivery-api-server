package com.delivery.mono.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequestDto(
        @NotBlank String name,
        @NotBlank String type
) {
}
