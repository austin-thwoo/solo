package com.noah.solo.domain.user.exception;

import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;
public class InvalidEmailAuthCodeException extends ApplicationException {
    public InvalidEmailAuthCodeException() {
        super(ErrorCode.INVALID_EMAIL_AUTH_CODE);
    }
}
