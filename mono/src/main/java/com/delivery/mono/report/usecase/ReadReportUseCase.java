package com.delivery.mono.report.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.report.dto.ReportDetailResponseDto;
import com.delivery.mono.report.dto.ReportSummaryResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

@UseCase("readReportUseCase")
public interface ReadReportUseCase {
    ReportDetailResponseDto readReport(UUID userId, UUID reportId);
    Page<ReportSummaryResponseDto> readReports(UUID userId, int page, int size, String orderBy, String sortBy);
    Page<ReportSummaryResponseDto> readAllReports(int page, int size, String orderBy, String sortBy);
    Page<ReportSummaryResponseDto> searchReports(int page, int size, String text);
}
