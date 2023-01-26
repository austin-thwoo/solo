package com.noah.solo.domain.user.auth.application;



import com.noah.solo.domain.user.dao.request.*;
import com.noah.solo.domain.user.auth.domain.EmailAuth;
import com.noah.solo.domain.user.dao.response.TokenResponse;
import com.noah.solo.domain.user.exception.DuplicatedEmailException;
import com.noah.solo.domain.user.exception.EmailAuthNotFoundException;
import com.noah.solo.domain.user.exception.NotAuthenticatedEmailException;
import com.noah.solo.domain.user.exception.UserNotFoundException;
import com.noah.solo.domain.user.repository.EmailAuthRepository;
import com.noah.solo.domain.user.repository.UserRepository;
import com.noah.solo.domain.user.user.domain.User;
import com.noah.solo.global.util.AuthMailDto;
import com.noah.solo.global.util.JwtTokenProvider;
import com.noah.solo.global.util.MailUtil;
import com.noah.solo.global.util.RandomUtil;
import com.noah.solo.global.vo.JwtTokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MailUtil mailUtil;
    private final EmailAuthRepository emailAuthRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void sendAuthEmail(AuthEmailRequest request) {
        String random6Number = RandomUtil.generateAuth6Number().toString();
        AuthMailDto authMailRequestDto = AuthMailDto.builder()
                .targetEmail(request.getEmail())
                .authCode(random6Number)
                .build();

        if (request.getType().equals(EmailAuth.EmailAuthType.SIGNUP)) {
            checkDuplicatedEmail(request.getEmail());
        }
        if (request.getType().equals(EmailAuth.EmailAuthType.PASSWORD)) {
            checkExistUserByEmail(request.getEmail());
        }

        EmailAuth emailAuth = new EmailAuth(request.getEmail(), random6Number, request.getType());

        emailAuthRepository.save(emailAuth);

        mailUtil.sendAuthMail(authMailRequestDto);
    }

    private void checkDuplicatedEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new DuplicatedEmailException();
        }
    }

    private void checkExistUserByEmail(String email) {
        userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    // validationAuthEmailCode
    @Transactional
    public void validateEmailAuthCode(AuthCodeValidationRequest request) {
        EmailAuth emailAuth = emailAuthRepository.findTopByEmailAndTypeAndExpiredAtBeforeNow(request.getEmail(), request.getType())
                .orElseThrow(EmailAuthNotFoundException::new);

        emailAuth.validateAuthCode(request.getAuthCode());

        emailAuth.completeAuth();
    }

    // signUp
    @Transactional
    public TokenResponse signup(SignUpRequest request) {
        checkEmailAuthExistsByEmailAndStatusAndType(request.getEmail(), EmailAuth.EmailAuthStatus.COMPLETE, EmailAuth.EmailAuthType.SIGNUP);

        User user = User.create(request.getEmail());
        user.placePassword(passwordEncoder, request.getPassword());

        userRepository.save(user);

        JwtTokenInfo tokenInfo = jwtTokenProvider.createToken(user.getId().toString());

        emailAuthRepository.deleteAllByEmail(user.getEmail());

        return new TokenResponse(tokenInfo);
    }

    // update password
    @Transactional
    public void updatePassword(UpdatePasswordRequest request) {
        checkEmailAuthExistsByEmailAndStatusAndType(request.getEmail(), EmailAuth.EmailAuthStatus.COMPLETE, EmailAuth.EmailAuthType.PASSWORD);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        user.updatePassword(passwordEncoder, request.getPassword());


        emailAuthRepository.deleteAllByEmail(user.getEmail());
    }

    private void checkEmailAuthExistsByEmailAndStatusAndType(String email, EmailAuth.EmailAuthStatus status, EmailAuth.EmailAuthType type) {
        if (!emailAuthRepository.existsByEmailAndStatusAndType(
                email, status, type)) {
            throw new NotAuthenticatedEmailException();
        }
    }

    // login
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        user.validatePasswordMatch(passwordEncoder, request.getPassword());

        JwtTokenInfo tokenInfo = jwtTokenProvider.createToken(user.getId().toString());


        return new TokenResponse(tokenInfo);
    }


}
