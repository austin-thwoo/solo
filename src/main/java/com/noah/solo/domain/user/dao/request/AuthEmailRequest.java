package com.noah.solo.domain.user.dao.request;


import com.noah.solo.domain.user.auth.domain.EmailAuth;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AuthEmailRequest {
    @Email
    @NotBlank
    private String email;

    @NotNull
    private EmailAuth.EmailAuthType type;
}
