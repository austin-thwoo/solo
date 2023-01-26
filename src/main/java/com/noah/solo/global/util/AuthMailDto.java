package com.noah.solo.global.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class AuthMailDto {
    private String targetEmail;
    private String authCode;
}
