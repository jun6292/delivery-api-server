package com.delivery.mono.report.usecase;

import com.delivery.mono.core.annotation.UseCase;

import java.util.UUID;

@UseCase("deleteReportUseCase")
public interface DeleteReportUseCase {
    void deleteReportByAdmin(UUID reportId);
    void deleteReportByUser(UUID userId, UUID reportId);
}
