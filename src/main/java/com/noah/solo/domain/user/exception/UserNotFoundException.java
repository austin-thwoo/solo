package com.noah.solo.domain.user.exception;


import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
