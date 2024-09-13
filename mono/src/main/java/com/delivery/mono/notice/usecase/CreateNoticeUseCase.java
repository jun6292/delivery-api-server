package com.delivery.mono.notice.usecase;

import com.delivery.mono.global.annotation.UseCase;
import com.delivery.mono.notice.dto.NoticeCreateRequestDto;

import java.util.UUID;

@UseCase("createNoticeUseCase")
public interface CreateNoticeUseCase {
    void createNotice(UUID userId, NoticeCreateRequestDto requestDto);
}
