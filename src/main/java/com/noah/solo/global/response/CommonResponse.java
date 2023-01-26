package com.noah.solo.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private final int status = 200;
    private T data;
    private PageInfo pageInfo;
    private String message;

    private CommonResponse() {
    }

    private CommonResponse(T data, PageInfo pageInfo, String message) {
        this.data = data;
        this.pageInfo = pageInfo;
        this.message = message;
    }


    public static <T> CommonResponse<T> success(T data, PageInfo pageInfo, String message) {
        return new CommonResponse<T>(data, pageInfo, message);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return success(data, null, message);
    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null, null);
    }

    public static <T> CommonResponse<T> success(String message) {
        return success(null, null, message);
    }

    public static <T> CommonResponse<T> success() {
        return success(null, null, null);
    }
}
