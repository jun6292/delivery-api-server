package com.delivery.mono.notice.service;

import com.delivery.mono.global.exception.BusinessLogicException;
import com.delivery.mono.global.exception.ExceptionCode;
import com.delivery.mono.notice.domain.Notice;
import com.delivery.mono.notice.dto.NoticeCreateRequestDto;
import com.delivery.mono.notice.repository.NoticeRepository;
import com.delivery.mono.notice.usecase.CreateNoticeUseCase;
import com.delivery.mono.user.domain.User;
import com.delivery.mono.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateNoticeServiceImplV1 implements CreateNoticeUseCase {
    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createNotice(UUID userId, NoticeCreateRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        Notice newNotice = Notice.builder()
                .title(requestDto.title())
                .content(requestDto.content())
                .user(user)
                .build();
        noticeRepository.save(newNotice);
    }
}
