package com.delivery.mono.review.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ReviewUpdateDTO {

    private UUID reviewId;
    private String review;
    private int rate;

}
