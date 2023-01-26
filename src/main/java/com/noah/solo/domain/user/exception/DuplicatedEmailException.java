package com.noah.solo.domain.user.exception;


import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;

public class DuplicatedEmailException extends ApplicationException {
    public DuplicatedEmailException() {
        super(ErrorCode.DUPLICATED_EMAIL);
    }
}
