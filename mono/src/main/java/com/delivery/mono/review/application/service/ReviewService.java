package com.delivery.mono.review.application.service;

import com.delivery.mono.review.application.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ReviewService {

    // 가게 후기 생성
    void createReview(ReviewRequestDTO reviewRequestDTO);
    
    // 가게 후기 조회
    ReviewResponseDTO findReviewById(UUID reviewId);

    // 가게 후기 수정
    ReviewResponseDTO updateReview(ReviewUpdateDTO reviewUpdateDTO);

    // 가게 후기 삭제
    void deleteReview (UUID reviewId);

    // 가게 후기 목록 조회
    Page<ReviewListDTO> getReviewsByStore(UUID storeId, int page, int size, String sortBy, boolean orderBy);

    // 가게 후기 신고
    void reportReview(ReviewReportDTO reviewReportDTO);
}
