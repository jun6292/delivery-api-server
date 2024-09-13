package com.delivery.mono.review.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewReportDTO {

    private UUID reviewId;
    private String report;
}
