package com.delivery.mono.notice.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.notice.dto.NoticeDetailResponseDto;
import com.delivery.mono.notice.dto.NoticeSummaryResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

@UseCase("readNoticeUseCase")
public interface ReadNoticeUseCase {
    NoticeDetailResponseDto readNoticeDetail(UUID noticeId);
    Page<NoticeSummaryResponseDto> readNoticeSummaryList(int page, int size, String sortBy, String orderBy);
    Page<NoticeSummaryResponseDto> searchNoticeSummaryList(int page, int size, String keyword);
}
