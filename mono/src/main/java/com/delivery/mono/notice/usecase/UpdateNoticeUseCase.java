package com.delivery.mono.notice.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.notice.dto.NoticeUpdateRequestDto;

import java.util.UUID;

@UseCase("updateNoticeUseCase")
public interface UpdateNoticeUseCase {
    void updateNotice(UUID noticeId, NoticeUpdateRequestDto requestDto);
}
