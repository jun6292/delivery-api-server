package com.delivery.mono.notice.service;

import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import com.delivery.mono.notice.domain.Notice;
import com.delivery.mono.notice.dto.NoticeDetailResponseDto;
import com.delivery.mono.notice.dto.NoticeSummaryResponseDto;
import com.delivery.mono.notice.repository.NoticeRepository;
import com.delivery.mono.notice.usecase.ReadNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadNoticeServiceImplV1 implements ReadNoticeUseCase {

    private final NoticeRepository noticeRepository;

    @Override
    public NoticeDetailResponseDto readNoticeDetail(UUID noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOTICE_NOT_FOUND));

        return NoticeDetailResponseDto.fromEntity(notice);
    }

    @Override
    public Page<NoticeSummaryResponseDto> readNoticeSummaryList(int page, int size, String sortBy, String orderBy) {
        Sort.Direction direction = orderBy.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Notice> noticePage = noticeRepository.findAllByIsDeletedFalse(pageable);
        return noticePage.map(NoticeSummaryResponseDto::fromEntityPage);
    }

    @Override
    public Page<NoticeSummaryResponseDto> searchNoticeSummaryList(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Notice> noticePage = noticeRepository.findByIsDeletedFalseAndTitleContaining(keyword, pageable);
        return noticePage.map(NoticeSummaryResponseDto::fromEntityPage);
    }
}
