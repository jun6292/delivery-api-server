package com.delivery.mono.notice.usecase;

import com.delivery.mono.core.annotation.UseCase;

import java.util.UUID;

@UseCase("deleteNoticeUseCase")
public interface DeleteNoticeUseCase {
    void deleteNotice(UUID noticeId);
}
