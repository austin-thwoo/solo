package com.noah.solo.domain.user.dao.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.noah.solo.global.vo.JwtTokenInfo;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenResponse {

    private String authToken;
    private Long expireLength;
    private String refreshToken;
    private Long refreshExpireLength;

    public TokenResponse(JwtTokenInfo tokenInfo) {
        this.authToken = tokenInfo.getAuthToken();
        this.expireLength = tokenInfo.getExpireLength();
        this.refreshToken = tokenInfo.getRefreshToken();
        this.refreshExpireLength = tokenInfo.getRefreshExpireLength();
    }
}
