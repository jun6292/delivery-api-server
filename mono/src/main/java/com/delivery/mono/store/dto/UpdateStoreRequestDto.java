package com.delivery.mono.store.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public record UpdateStoreRequestDto(
        @NotBlank String name,
        @NotBlank String address,
        @NotBlank String number,
        List<UUID> categoryIds
) {
}
