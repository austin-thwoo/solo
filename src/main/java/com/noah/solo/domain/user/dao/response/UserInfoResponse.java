package com.noah.solo.domain.user.dao.response;

import com.noah.solo.domain.user.user.domain.User;
import com.noah.solo.domain.user.user.domain.common.Profile;
import com.noah.solo.domain.user.user.domain.common.UserStatus;
import lombok.Getter;

@Getter
public class UserInfoResponse {
    private Long userId;
    private String email;
    private UserStatus status;
    private Profile profile;
//    private UserConfig config;

    public UserInfoResponse(User user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.profile = user.getProfile();
//        this.config = user.getConfig();
    }
}
