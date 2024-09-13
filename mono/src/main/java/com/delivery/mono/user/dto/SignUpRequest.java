package com.delivery.mono.user.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private String nickname;
    private String address;
    private String phoneNumber;
}