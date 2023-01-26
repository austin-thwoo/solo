package com.noah.solo.domain.user.user.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Embeddable
@Getter
@AllArgsConstructor
@Builder
public class Profile {

    private String nickname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birthDate;
    private Double height;
    private Double weight;
    @Enumerated(EnumType.STRING)
    private DeviceConnectionStatus deviceConnectionStatus;

    protected Profile() {
    }

    public enum Gender {
        MALE, FEMALE;

    }

    public enum DeviceConnectionStatus {
        CONNECTED, NOT_CONNECTED
    }

    public static Profile createDefaultProfile() {
        return Profile.builder()
                .nickname("")
                .gender(Gender.MALE)
                .birthDate(LocalDate.now())
                .height(0.0)
                .weight(0.0)
                .deviceConnectionStatus(DeviceConnectionStatus.NOT_CONNECTED)
                .build();
    }

    public void updateDeviceConnectionStatus(DeviceConnectionStatus status) {
        this.deviceConnectionStatus = status;
    }
}
