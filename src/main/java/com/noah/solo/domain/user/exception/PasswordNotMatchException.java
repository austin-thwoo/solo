package com.noah.solo.domain.user.exception;

import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;

public class PasswordNotMatchException extends ApplicationException {
    public PasswordNotMatchException() {
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
