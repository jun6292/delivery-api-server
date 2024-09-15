package com.delivery.mono.report.service;

import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import com.delivery.mono.report.domain.Report;
import com.delivery.mono.report.domain.type.EReportTargetType;
import com.delivery.mono.report.dto.UpdateReportRequestDto;
import com.delivery.mono.report.repository.ReportRepository;
import com.delivery.mono.report.usecase.UpdateReportUseCase;
import com.delivery.mono.user.domain.User;
import com.delivery.mono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateReportServiceImplV1 implements UpdateReportUseCase {

    private final UserRepository userRepository;
    private final ReportRepository reportRepository;

    @Override
    @Transactional
    public void updateReport(UUID userId, UUID reportId, UpdateReportRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
        report.update(
                requestDto.title(),
                requestDto.content(),
                EReportTargetType.valueOf(requestDto.targetType()),
                requestDto.targetId()
        );
    }
}
