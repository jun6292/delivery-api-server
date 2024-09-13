package com.delivery.mono.notice.dto;

import jakarta.validation.constraints.NotNull;

public record NoticeCreateRequestDto(
        @NotNull String title,
        @NotNull String content
) {
}
