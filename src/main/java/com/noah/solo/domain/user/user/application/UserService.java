package com.noah.solo.domain.user.user.application;



import com.noah.solo.domain.user.dao.request.RegisterProfileRequest;
import com.noah.solo.domain.user.dao.request.UpdateDeviceConnectionStatusRequest;
import com.noah.solo.domain.user.dao.response.UserInfoResponse;
import com.noah.solo.domain.user.exception.UserNotFoundException;
import com.noah.solo.domain.user.repository.UserJpaRepository;
import com.noah.solo.domain.user.repository.UserRepository;
import com.noah.solo.domain.user.user.domain.User;
import com.noah.solo.domain.user.user.domain.common.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfoResponse search(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        return new UserInfoResponse(user);
    }

    @Transactional
    public UserInfoResponse registerProfileById(Long userId, RegisterProfileRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        Profile profile = Profile.builder()
                .weight(request.getWeight())
                .height(request.getHeight())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .nickname(request.getNickname())
                .build();

        user.updateProfile(profile);

        userRepository.save(user);

        return new UserInfoResponse(user);
    }

    public UserInfoResponse getUserinfoById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        return new UserInfoResponse(user);
    }

//    @Transactional
//    public UserInfoResponse updateUserConfig(Long userId, RegisterConfigRequest request) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(UserNotFoundException::new);
//
//        user.updateConfig(request.getConfig());
//
//        return new UserInfoResponse(user);
//    }

    @Transactional
    public void updateDeviceConnectionStatus(Long userId, UpdateDeviceConnectionStatusRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        user.updateDeviceConnectionStatus(request.getStatus());
    }
}
