package com.noah.solo.domain.user.exception;

import com.noah.solo.global.error.ApplicationException;
import com.noah.solo.global.error.ErrorCode;

public class CanNotSearchMeException extends ApplicationException {
    public CanNotSearchMeException() {
        super(ErrorCode.CAN_NOT_SEARCH_ME);
    }
}
