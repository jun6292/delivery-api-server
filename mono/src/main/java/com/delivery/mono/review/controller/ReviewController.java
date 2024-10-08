package com.delivery.mono.review.controller;

import com.delivery.mono.review.application.dto.*;
import com.delivery.mono.review.application.service.ReviewService;
import com.delivery.mono.user.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2(topic = "Review Controller")
@RequestMapping("/api/v1/stores")
public class ReviewController {

    private final ReviewService reviewService;

    // 가게 후기 작성
    @PostMapping("/{storeId}/reviews")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> createReview(@PathVariable("storeId") UUID storeId, @AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody ReviewRequestDTO reviewRequestDTO) {

        log.info("Review Controller | POST Create Review");

        reviewRequestDTO.setStoreId(storeId);

        UUID userId = userPrincipal.getId();
        reviewRequestDTO.setUserId(userId);

        reviewService.createReview(reviewRequestDTO);

        return ResponseEntity.ok("후기 작성이 성공적으로 되었습니다.");
    }

    // 가게 후기 조회
    @GetMapping("/reviews/{reviewId}")
    @PreAuthorize("hasRole('USER') or hasRole('STORE') or hasRole('ADMIN')")
    public ResponseEntity<ReviewResponseDTO> findReviewById(@PathVariable("reviewId") UUID reviewId) {

        log.info("Review Controller | GET Find Review ById");

        ReviewResponseDTO result = reviewService.findReviewById(reviewId);

        return ResponseEntity.ok(result);
    }

    // 가게 후기 수정
    @PutMapping("/reviews/{reviewId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ReviewResponseDTO> updateReview(@PathVariable UUID reviewId, @RequestBody ReviewUpdateDTO reviewUpdateDTO) {

        log.info("Review Controller | PUT Update Review");

        reviewUpdateDTO.setReviewId(reviewId);
        ReviewResponseDTO result = reviewService.updateReview(reviewUpdateDTO);

        return ResponseEntity.ok(result);
    }

    // 가게 후기 삭제
    @DeleteMapping("/reviews/{reviewId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> deleteReview(@PathVariable UUID reviewId) {

        log.info("Review Controller | DELETE Delete Review");

        reviewService.deleteReview(reviewId);

        return ResponseEntity.ok("후기 삭제가 성공적으로 되었습니다.");
    }

    // 가게 후기 목록 조회
    @GetMapping("/{storeId}/reviews")
    @PreAuthorize("hasRole('USER') or hasRole('STORE') or hasRole('ADMIN')")
    public Page<ReviewListDTO> getReviewsByStore(@PathVariable UUID storeId,
                                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                                 @RequestParam(value = "sort", defaultValue = "createdAt") String sortBy,
                                                 @RequestParam(value = "desc", defaultValue = "true") boolean orderBy) {

        log.info("Review Controller | GET getReviews By Store");

        return reviewService.getReviewsByStore(storeId, page-1, size, sortBy, orderBy);
    }

    // 가게 후기 신고
    @PostMapping("/reviews/report/{reviewId}")
    @PreAuthorize("hasRole('USER') or hasRole('STORE') or hasRole('ADMIN')")
    public ResponseEntity<String> reportReview(@PathVariable UUID reviewId, @RequestBody ReviewReportDTO reviewReportDTO){

        log.info("Review Controller | POST Report Review");

        reviewReportDTO.setReviewId(reviewId);
        reviewService.reportReview(reviewReportDTO);

        return ResponseEntity.ok("후기 신고가 성공적으로 되었습니다.");
    }
}
