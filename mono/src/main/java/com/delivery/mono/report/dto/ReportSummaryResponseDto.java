package com.delivery.mono.report.dto;

import com.delivery.mono.report.domain.Report;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ReportSummaryResponseDto(
        UUID reportId,
        UUID targetId,
        String targetType,
        String title,
        String status,
        String reporterName
) {
    public static ReportSummaryResponseDto fromEntity(Report report) {
        return ReportSummaryResponseDto.builder()
                .reportId(report.getId())
                .targetId(report.getTargetId())
                .targetType(report.getTargetType().toString())
                .title(report.getTitle())
                .status(report.getStatus().toString())
                .reporterName(report.getUser().getNickname())
                .build();
    }
}
