package com.noah.solo.domain.user.exception;


import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;

public class EmailAuthNotFoundException extends ApplicationException {
    public EmailAuthNotFoundException() {
        super(ErrorCode.EMAIL_AUTH_NOT_FOUNT);
    }
}
