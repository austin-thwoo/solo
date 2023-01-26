package com.noah.solo.domain.user.exception;

import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;

public class NotAuthenticatedEmailException extends ApplicationException {
    public NotAuthenticatedEmailException() {
        super(ErrorCode.NOT_AUTHENTICATED_EMAIL);
    }
}
