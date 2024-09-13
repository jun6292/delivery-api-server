package com.delivery.mono.notice.service;

import com.delivery.mono.global.exception.BusinessLogicException;
import com.delivery.mono.global.exception.ExceptionCode;
import com.delivery.mono.notice.domain.Notice;
import com.delivery.mono.notice.dto.NoticeUpdateRequestDto;
import com.delivery.mono.notice.repository.NoticeRepository;
import com.delivery.mono.notice.usecase.UpdateNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateNoticeServiceImplV1 implements UpdateNoticeUseCase {

    private final NoticeRepository noticeRepository;

    @Override
    @Transactional
    public void updateNotice(UUID noticeId, NoticeUpdateRequestDto requestDto) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOTICE_NOT_FOUND));
        notice.update(requestDto.title(), requestDto.content());
    }
}
