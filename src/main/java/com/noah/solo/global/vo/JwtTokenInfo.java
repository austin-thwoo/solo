package com.noah.solo.global.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class JwtTokenInfo {

    private String authToken;
    private Long expireLength;
    private String refreshToken;
    private Long refreshExpireLength;

}
