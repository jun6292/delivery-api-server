package com.delivery.mono.report.service;

import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import com.delivery.mono.report.domain.Report;
import com.delivery.mono.report.domain.type.EReportTargetType;
import com.delivery.mono.report.dto.CreateReplyRequestDto;
import com.delivery.mono.report.dto.CreateReportRequestDto;
import com.delivery.mono.report.repository.ReportRepository;
import com.delivery.mono.report.usecase.CreateReportUseCase;
import com.delivery.mono.user.domain.User;
import com.delivery.mono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateReportServiceImplV1 implements CreateReportUseCase {

    private final UserRepository userRepository;
    private final ReportRepository reportRepository;

    @Override
    @Transactional
    public void createReport(UUID userId, CreateReportRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        Report newReport = Report.builder()
                .title(requestDto.title())
                .content(requestDto.content())
                .targetId(requestDto.targetId())
                .user(user)
                .targetType(EReportTargetType.valueOf(requestDto.targetType()))
                .build();
        reportRepository.save(newReport);
    }

    @Override
    @Transactional
    public void replyReport(UUID reportId, CreateReplyRequestDto requestDto) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
        report.setReply(requestDto.content());
    }
}
