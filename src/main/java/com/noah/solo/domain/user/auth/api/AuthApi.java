package com.noah.solo.domain.user.auth.api;


import com.noah.solo.domain.user.auth.application.AuthService;
import com.noah.solo.domain.user.dao.request.*;
import com.noah.solo.domain.user.dao.response.TokenResponse;
import com.noah.solo.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<TokenResponse>> login(@RequestBody @Valid LoginRequest request) {
        TokenResponse response = authService.login(request);

        return ResponseEntity.ok(CommonResponse.success(response, "success login"));
    }

    // signup
    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<TokenResponse>> signup(@RequestBody @Valid SignUpRequest request) {
        TokenResponse response = authService.signup(request);
        return ResponseEntity.ok(CommonResponse.success(response, "success signup"));
    }

    // update 0password
    @PostMapping("/password")
    public ResponseEntity<CommonResponse<?>> updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        authService.updatePassword(request);
        return ResponseEntity.ok(CommonResponse.success());
    }

    // send email
    @PostMapping("/email")
    public ResponseEntity<CommonResponse<?>> email(@RequestBody @Valid AuthEmailRequest request) {
        authService.sendAuthEmail(request);
        return ResponseEntity.ok(CommonResponse.success("success to request send auth email"));
    }

    // email code validation
    @PostMapping("/email/auth")
    public ResponseEntity<CommonResponse<?>> validateEmailAuthCode(@RequestBody @Valid AuthCodeValidationRequest request) {
        authService.validateEmailAuthCode(request);

        return ResponseEntity.ok(CommonResponse.success("success validation email auth code"));
    }


}
