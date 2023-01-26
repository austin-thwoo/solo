package com.noah.solo.domain.user.dao.request;


import com.noah.solo.domain.user.user.domain.common.Profile;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateDeviceConnectionStatusRequest {

    @NotNull
    private Profile.DeviceConnectionStatus status;
}
