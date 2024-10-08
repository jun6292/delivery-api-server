package com.delivery.mono.notice.controller;

import com.delivery.mono.core.annotation.UserId;
import com.delivery.mono.notice.dto.NoticeCreateRequestDto;
import com.delivery.mono.notice.dto.NoticeUpdateRequestDto;
import com.delivery.mono.notice.usecase.CreateNoticeUseCase;
import com.delivery.mono.notice.usecase.DeleteNoticeUseCase;
import com.delivery.mono.notice.usecase.ReadNoticeUseCase;
import com.delivery.mono.notice.usecase.UpdateNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
public class NoticeController {
    private final CreateNoticeUseCase createNoticeUseCase;
    private final ReadNoticeUseCase readNoticeUseCase;
    private final UpdateNoticeUseCase updateNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    /**
     * 공지사항 목록 조회
     * PUBLIC
     */
    @GetMapping("/public")
    public ResponseEntity<?> readNoticeList(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt") String sortBy,
            @RequestParam(value = "orderBy", defaultValue = "DESC") String orderBy
    ) {
        return ResponseEntity.ok(readNoticeUseCase.readNoticeSummaryList(page ,size, sortBy, orderBy));
    }

    /**
     * 공지사항 상세 조회
     * PUBLIC
     */
    @GetMapping("/public/{noticeId}")
    public ResponseEntity<?> readNoticeDetail(
            @PathVariable(value = "noticeId") UUID noticeId
    ) {
        return ResponseEntity.ok(readNoticeUseCase.readNoticeDetail(noticeId));
    }

    /**
     * 공지사항 검색
     * PUBLIC
     */
    @GetMapping("/public/search")
    public ResponseEntity<?> searchNotice(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "text") String text
    ) {
        return ResponseEntity.ok(readNoticeUseCase.searchNoticeSummaryList(page, size, text));
    }


    /**
     * 공지사항 등록
     * ADMIN
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<?> createNotice(
            @UserId UUID userId,
            @RequestBody NoticeCreateRequestDto noticeCreateRequestDto
    ) {
        createNoticeUseCase.createNotice(userId, noticeCreateRequestDto);
        return ResponseEntity.ok().build();
    }

    /**
     * 공지사항 수정
     * ADMIN
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{noticeId}")
    public ResponseEntity<?> updateNotice(
            @PathVariable(value = "noticeId") UUID noticeId,
            @RequestBody NoticeUpdateRequestDto noticeUpdateRequestDto
    ) {
        updateNoticeUseCase.updateNotice(noticeId, noticeUpdateRequestDto);
        return ResponseEntity.ok().build();
    }

    /**
     * 공지사항 삭제
     * ADMIN
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{noticeId}")
    public ResponseEntity<?> deleteNotice(
            @PathVariable(value = "noticeId") UUID noticeId
    ) {
        deleteNoticeUseCase.deleteNotice(noticeId);
        return ResponseEntity.noContent().build();
    }
}
