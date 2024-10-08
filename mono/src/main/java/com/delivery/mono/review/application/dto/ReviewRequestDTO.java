package com.delivery.mono.review.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewRequestDTO {

    private UUID userId;
    private UUID storeId;
    private UUID orderId;
    private String review;
    private int rate;

}
