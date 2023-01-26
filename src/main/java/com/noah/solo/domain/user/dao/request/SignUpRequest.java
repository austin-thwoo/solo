package com.noah.solo.domain.user.dao.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&.])[A-Za-z\\d$@$!%*#?&.]{8,20}$", message = "비밀번호는 대소문자, 숫자, 특수문자 세가지 조합 이상으로 이루어진 8 ~ 20자리 문자여야합니다.")
    private String password;
    @NotBlank
    private String passwordCheck;

    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isValidPasswordAndPasswordCheck() {
        return passwordCheck.equals(password);
    }


}
