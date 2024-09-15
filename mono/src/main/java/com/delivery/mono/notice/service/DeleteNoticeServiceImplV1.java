package com.delivery.mono.notice.service;

import com.delivery.mono.core.exception.BusinessLogicException;
import com.delivery.mono.core.exception.ExceptionCode;
import com.delivery.mono.notice.domain.Notice;
import com.delivery.mono.notice.repository.NoticeRepository;
import com.delivery.mono.notice.usecase.DeleteNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteNoticeServiceImplV1 implements DeleteNoticeUseCase {

    private final NoticeRepository noticeRepository;

    @Override
    @Transactional
    public void deleteNotice(UUID noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOTICE_NOT_FOUND));
        notice.delete();
    }
}
