package com.delivery.mono.category.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryType {
    STORE("store"),
    LOCAL("local");

    private final String categoryType;
}
