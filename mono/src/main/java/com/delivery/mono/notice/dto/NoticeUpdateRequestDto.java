package com.delivery.mono.notice.dto;

import jakarta.validation.constraints.NotNull;

public record NoticeUpdateRequestDto(
        @NotNull String title,
        @NotNull String content
) {
}
