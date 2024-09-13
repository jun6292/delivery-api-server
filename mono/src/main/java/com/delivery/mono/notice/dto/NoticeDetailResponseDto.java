package com.delivery.mono.notice.dto;

import com.delivery.mono.notice.domain.Notice;
import lombok.Builder;

import java.util.UUID;

@Builder
public record NoticeDetailResponseDto(
        UUID noticeId,
        String title,
        String content,
        String createdAt,
        String updatedAt,
        String authorName
) {
    public static NoticeDetailResponseDto fromEntity(Notice notice) {
        return NoticeDetailResponseDto.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt().toString())
                .updatedAt(notice.getUpdatedAt().toString())
                .authorName(notice.getUser().getNickname())
                .build();
    }
}
