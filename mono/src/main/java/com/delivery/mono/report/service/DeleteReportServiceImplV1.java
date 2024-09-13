package com.delivery.mono.report.service;

import com.delivery.mono.global.exception.BusinessLogicException;
import com.delivery.mono.global.exception.ExceptionCode;
import com.delivery.mono.report.domain.Report;
import com.delivery.mono.report.repository.ReportRepository;
import com.delivery.mono.report.usecase.DeleteReportUseCase;
import com.delivery.mono.user.domain.User;
import com.delivery.mono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteReportServiceImplV1 implements DeleteReportUseCase {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void deleteReportByAdmin(UUID reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
        report.delete();
    }

    @Override
    @Transactional
    public void deleteReportByUser(UUID userId, UUID reportId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
        report.delete();
    }
}
