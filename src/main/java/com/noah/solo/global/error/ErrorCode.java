package com.noah.solo.global.error;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ErrorCode {
    /**
     * COMMON ERROR CODE
     */
    INVALID_INPUT_VALUE(400, "C001", "올바르지 않은 형식입니다."),
    METHOD_NOT_ALLOWED(405, "C002", "지원하지 않는 메소드입니다."),
    ENTITY_NOT_FOUND(400, "C003", "해당 엔티티를 찾을 수가 없습니다."),
    INTERNAL_SERVER_ERROR(500, "C004", "알 수 없는 에러 (서버 에러)"),
    INVALID_TYPE_VALUE(400, "C005", "타입이 올바르지 않습니다."),
    ACCESS_DENIED(403, "C006", "권한이 없습니다."),
    INVALID_TOKEN(401, "C007", "토큰이 없거나 올바르지 않습니다."),
    API_CALL_FAILED(500, "C008", "서버 간 통신 중 에러가 발생했습니다."),
    NOT_ACCEPT_IP(400, "C009", "허용하지 않은 IP 입니다"),
    STORAGE_FILE_NOT_FOUND(404, "C010", "존재하지 않는 파일입니다."),
    FAIL_UPLOAD_FILE(404, "C011", "파일 업로드 중 에러가 발생했습니다."),


    /**
     * USER
     */
    PASSWORD_NOT_MATCH(400, "U001", "비밀번호가 올바르지 않습니다"),
    USER_NOT_FOUND(404, "U002", "유저가 존재하지 않습니다."),
    DUPLICATED_USERNAME(400, "U003", "중복된 아이디가 존재합니다."),
    CAN_NOT_SEARCH_ME(404, "U004", "자기 자신을 검색할 수 없습니다."),


    /**
     * EmailAuth
     */
    EMAIL_AUTH_NOT_FOUNT(404, "EA001", "유효한 이메일 인증이 존재하지 않습니다."),
    INVALID_EMAIL_AUTH_CODE(400, "EA002", "이메일 인증 코드가 유효하지 않습니다."),
    NOT_AUTHENTICATED_EMAIL(400, "EA003", "인증되지 않은 이메일입니다."),
    DUPLICATED_EMAIL(400, "U003", "중복된 이메일로 가입된 회원이 존재합니다."),


    /**
     * Social
     */
    SOCIAL_NOT_FOUND(404, "S001", "소셜 정보가 존재하지 않습니다."),
    ALREADY_FOLLOWING(400, "SOO2", "이미 팔로우 요청을 보냈습니다."),
    INVALID_TO_USER_ID(400, "S003", "유효하지 않은 요청입니다."),
    ALREADY_FOLLOWED(409, "SOO4", "이미 해당 유저에게 팔로우 요청을 받았습니다."),
    CAN_NOT_FOLLOW_ME(404, "S005", "자기 자신을 팔로우할 수 없습니다."),
    ;


    private final int status;
    private final String errorCode;
    private final String message;


    ErrorCode(int status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
