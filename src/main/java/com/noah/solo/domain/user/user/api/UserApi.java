package com.noah.solo.domain.user.user.api;


import com.noah.solo.domain.user.dao.request.RegisterProfileRequest;
import com.noah.solo.domain.user.dao.request.UpdateDeviceConnectionStatusRequest;
import com.noah.solo.domain.user.dao.response.UserInfoResponse;
import com.noah.solo.domain.user.exception.CanNotSearchMeException;
import com.noah.solo.domain.user.repository.UserJpaRepository;
import com.noah.solo.domain.user.user.application.UserService;
import com.noah.solo.domain.user.user.domain.User;
import com.noah.solo.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Validated
public class UserApi {

    private final UserService userService;
    private final UserJpaRepository userJpaRepository;


    @GetMapping("/search")
    public ResponseEntity<CommonResponse<UserInfoResponse>> search(@AuthenticationPrincipal User principle,
                                                                   @RequestParam(name = "email") @Email String email) {

        if (principle.getEmail().equals(email)) {
            throw new CanNotSearchMeException();
        }
        UserInfoResponse response = userService.search(email);

        return ResponseEntity.ok(CommonResponse.success(response));
    }

    // profile register
    @PutMapping("/profile")
    public ResponseEntity<CommonResponse<UserInfoResponse>> registerProfile(@AuthenticationPrincipal User principle,
                                                                            @RequestBody @Valid RegisterProfileRequest request) {
        UserInfoResponse response = userService.registerProfileById(principle.getId(), request);

        return ResponseEntity.ok(CommonResponse.success(response));
    }

    // get user info
    @GetMapping("/me")
    public ResponseEntity<CommonResponse<UserInfoResponse>> getMyUserInfo(@AuthenticationPrincipal User principle) {
        UserInfoResponse response = userService.getUserinfoById(principle.getId());

        return ResponseEntity.ok(CommonResponse.success(response));
    }

    @PostMapping("/exit")
    public ResponseEntity<CommonResponse<?>> exit(@AuthenticationPrincipal User user) {

        userJpaRepository.delete(user);

        return ResponseEntity.ok(CommonResponse.success());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponse<UserInfoResponse>> getUserInfoById(@AuthenticationPrincipal User principle,
                                                                            @PathVariable("userId") Long userId) {
        UserInfoResponse response = userService.getUserinfoById(userId);

        return ResponseEntity.ok(CommonResponse.success(response));
    }

//    @PutMapping("/config")
//    public ResponseEntity<CommonResponse<?>> registerConfig(@AuthenticationPrincipal User principle,
//                                                            @RequestBody @Valid RegisterConfigRequest request) {
//
//        userService.updateUserConfig(principle.getId(), request);
//        return ResponseEntity.ok(CommonResponse.success("success register config"));
//    }

    @PutMapping("/profile/device-connection")
    public ResponseEntity<CommonResponse<?>> updateDeviceConnection(@AuthenticationPrincipal User principle,
                                                                    @RequestBody @Valid UpdateDeviceConnectionStatusRequest request) {

        userService.updateDeviceConnectionStatus(principle.getId(), request);

        return ResponseEntity.ok(CommonResponse.success("success update device connection status"));
    }
    @GetMapping("/logout/{userId}")
    public ResponseEntity<CommonResponse<UserInfoResponse>> singOut(@AuthenticationPrincipal User principle,
                                                                            @PathVariable("userId") Long userId) {


        return ResponseEntity.ok(CommonResponse.success(response));
    }

}
