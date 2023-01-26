package com.noah.solo.domain.user.dao.request;


import com.noah.solo.domain.user.user.domain.common.Profile;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class RegisterProfileRequest {
    @NotBlank
    private String nickname;
    @NotNull
    private Profile.Gender gender;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Double height;
    @NotNull
    private Double weight;
}
