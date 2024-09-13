package com.delivery.mono.report.dto;

import com.delivery.mono.report.domain.Report;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ReportDetailResponseDto(
        UUID reportId,
        UUID targetId,
        String targetType,
        String title,
        String content,
        String status,
        String reporterName
) {
    public static ReportDetailResponseDto fromEntity(Report report) {
        return ReportDetailResponseDto.builder()
                .reportId(report.getId())
                .targetId(report.getTargetId())
                .targetType(report.getTargetType().toString())
                .title(report.getTitle())
                .content(report.getContent())
                .status(report.getStatus().toString())
                .reporterName(report.getUser().getNickname())
                .build();
    }
}
