package com.delivery.mono.report.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.report.dto.UpdateReportRequestDto;

import java.util.UUID;

@UseCase("updateReportUseCase")
public interface UpdateReportUseCase {
    void updateReport(UUID userId, UUID reportId, UpdateReportRequestDto updateReportRequestDto);
}
