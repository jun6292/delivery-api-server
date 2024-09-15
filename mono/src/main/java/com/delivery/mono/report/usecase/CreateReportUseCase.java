package com.delivery.mono.report.usecase;

import com.delivery.mono.core.annotation.UseCase;
import com.delivery.mono.report.dto.CreateReplyRequestDto;
import com.delivery.mono.report.dto.CreateReportRequestDto;

import java.util.UUID;

@UseCase("createReportUseCase")
public interface CreateReportUseCase {
    void createReport(UUID userId, CreateReportRequestDto requestDto);
    void replyReport(UUID reportId, CreateReplyRequestDto requestDto);
}
